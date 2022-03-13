package com.example.demo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/users")
@Slf4j
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping("/")
	public User saveUser(@RequestBody User User) {
		log.info("Inside saveUser method of User Controller");
		return userService.saveUser(User);
	}
	
	/*
	 * @GetMapping("/{id}") public Optional<User> findUserById(@PathVariable("id")
	 * Long id) { log.info("Inside findUserById method of User Controller"); return
	 * userService.findUserById(id); }
	 */
	
	@GetMapping("/{id}")
	public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") Long userId) {
		
		return userService.getUserWithDepartment(userId);
	}
}
