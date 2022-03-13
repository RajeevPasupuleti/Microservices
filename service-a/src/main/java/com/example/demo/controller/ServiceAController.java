package com.example.demo.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

@RestController
@RequestMapping("/a")
public class ServiceAController {
	
	@Autowired
	private RestTemplate restTemplate;
	
	private final String BASE_URL = "http://localhost:8081/";
	
	private final String SERVICE_A = "serviceA";
	
	int count = 0;
	
	@GetMapping
	//@CircuitBreaker(name = SERVICE_A,fallbackMethod = "fallbackMethod")
	//@Retry(name = SERVICE_A)
	@RateLimiter(name = SERVICE_A)
	public String serviceA() {
		System.out.println("Retry count is " + count++ + " at " + new Date());
		String response = restTemplate.getForObject(BASE_URL+"b", String.class);
		return "Service A called service B - response is " + response;
	}
	
	public String fallbackMethod(Exception ex) {
		return "Service B is not available!! Please try again later";
	}
}
