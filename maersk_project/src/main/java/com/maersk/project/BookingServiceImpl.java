package com.maersk.project;

import java.util.HashMap;
import java.util.Map;

import org.apache.tomcat.util.json.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookingServiceImpl implements BookingService {

	@Autowired
	ContainerRepository containerRepository;
	
	@Override
	public Object bookContainer(Container container) {
		Map<String, String> result = new HashMap<>();
		container.setContainerId(createContainerid());
		container = containerRepository.save(container);
		result.put("bookingref", container.getContainerId());
		return result;
	}

	private String createContainerid() {
		String alphaNumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvxyz";
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i< 32; i++) {
			if(i == 8 || i == 12 || i == 16 || i == 20) {
				sb.append("-");
			}else {
				int index =(int)(alphaNumeric.length() * Math.random());
				sb.append(alphaNumeric.charAt(index));
			}
		}
		return sb.toString();
	}

	@Override
	public Object checkAvailability() {
		Map<String, Object> result = new HashMap<>();
		try {
			result = new ExternalService().checkAvailability();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		result.put("availableSpace", Integer.valueOf((String) result.get("availableSpace")) > 0 ? true:false);
		return result;
	}
	
}
