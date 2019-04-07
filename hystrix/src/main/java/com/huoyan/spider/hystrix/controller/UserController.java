package com.huoyan.spider.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.Semaphore;

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

	@GetMapping("/hystrix/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback")
	public User find(@PathVariable("id") int id) {
		return restTemplate.getForObject("http://localhost:8080/user/" + id + "/find", User.class);
	}

	/**
	 * 方法调用，和断路方法在一个线程池中运行，如果不配置，则是不同的线程
	 * @param id
	 * @return
	 */
	@GetMapping("/hystrixSemaphore/{id}")
	@HystrixCommand(fallbackMethod = "findByIdFallback" , commandProperties = @HystrixProperty(name = "execution.isolation.strategy" , value = "SEMAPHORE"))
	public User hystrixSempore(@PathVariable("id") int id) {
		return restTemplate.getForObject("http://localhost:8080/user/" + id + "/find", User.class);
	}

	public User findByIdFallback(int id){
		User user = new User();
		user.setId(id);
		user.setName("fallbackName");
		user.setAddress("fallbackAddress");
		return user;
	}
}
