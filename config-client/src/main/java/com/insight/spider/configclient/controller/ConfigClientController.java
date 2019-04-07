package com.insight.spider.configclient.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/4/7
 * @since: JDK 1.8
 * @version: v1.0
 */

@RestController
public class ConfigClientController {

	@Value("${profile}")
	String profile ;

	@GetMapping("/hi")
	public String getProfile() {

		return profile;
	}
}
