package com.insight.spider.ribbon.controller;

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

	@GetMapping("/provider")
	public String find() {
		String retu = restTemplate.getForObject("http://eureka-client/testribbon", String.class);
		System.out.println(retu);
		return retu;
	}
}
