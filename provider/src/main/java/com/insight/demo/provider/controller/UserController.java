package com.insight.demo.provider.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/28
 * @since: JDK 1.8
 * @version: v1.0
 */

@RestController
public class UserController {

	@Autowired
	private RestTemplate restTemplate;

	@GetMapping("/provider/{id}")
	public User find(@PathVariable("id") int id) {
		return restTemplate.getForObject("http://localhost:8080/user/" + id + "/find", User.class);
	}
}
