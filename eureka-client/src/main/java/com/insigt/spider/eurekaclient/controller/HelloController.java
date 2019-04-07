package com.insigt.spider.eurekaclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/28
 * @since: JDK 1.8
 * @version: v1.0
 */

@RestController
@RequestMapping("/")
public class HelloController {

	@Value("${server.port}")
	private String port;

	@GetMapping("/testribbon")
	public String test() {
		return "prot : " + port;
	}
}
