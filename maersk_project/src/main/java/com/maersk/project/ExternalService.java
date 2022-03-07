package com.maersk.project;

import java.util.LinkedHashMap;

import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;

import com.fasterxml.jackson.databind.util.JSONPObject;

public class ExternalService {
	public LinkedHashMap<String, Object> checkAvailability() throws ParseException {
		JSONParser parse = new JSONParser("{\"availableSpace\":\"100\"}"); 
		LinkedHashMap<String, Object> map = parse.parseObject();
		return map;
	}
}
