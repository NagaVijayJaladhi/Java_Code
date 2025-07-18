package com.jaladhi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ActuatorExample {

	@GetMapping("/hello")
	public String hello() {
		return "Hello User!";
	}
	
}
