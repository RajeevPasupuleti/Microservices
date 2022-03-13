package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.VO.Department;
import com.example.demo.VO.ResponseTemplateVO;
import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User User) {
		log.info("Inside saveUser method of UserService");
		return userRepository.save(User);
	}

	public Optional<User> findUserById(Long id) {
		log.info("Inside findUserById method of UserService");
		return userRepository.findById(id);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		log.info("Inside getUserWithDepartment of UserService");
		ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);

		Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
				Department.class);
		responseTemplateVO.setDepartment(department);
		responseTemplateVO.setUser(user);

		return responseTemplateVO;

	}
}
