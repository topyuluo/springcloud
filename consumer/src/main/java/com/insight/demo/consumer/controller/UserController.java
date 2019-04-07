package com.insight.demo.consumer.controller;

import com.insight.demo.consumer.orm.entity.User;
import com.insight.demo.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/28
 * @since: JDK 1.8
 * @version: v1.0
 */

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;

	@Value("${name}")
	private String profile ;

	@GetMapping("/hi")
	public String hi() {
		return profile;
	}

	@GetMapping("/findAll")
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/{id}/find")
	public User find(@PathVariable("id") int id) {
		return userService.findUserById(id);
	}

	@PostMapping("/insert")
	public int insert(@RequestBody User user) {
		return userService.insert(user);
	}


}
