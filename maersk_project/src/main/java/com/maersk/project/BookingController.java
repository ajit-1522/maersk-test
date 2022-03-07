package com.maersk.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
	
	@Autowired
	private BookingService bookingService;
	
	@GetMapping(value = "/checkAvailability")
	public Object checkAvailability(){
		return bookingService.checkAvailability();
	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public Object bookContainer(@RequestBody Container container){
		return bookingService.bookContainer(container);
	}
}
