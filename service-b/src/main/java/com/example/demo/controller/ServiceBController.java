package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class ServiceBController {
	
	private int count = 0;
	@GetMapping
	public String serviceB() {
		return "Hello from Service - B" + count++;
	}

}
