package com.insigt.spider.eurekaclient;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
//@EnableEurekaClient
@RestController
public class EurekaClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaClientApplication.class, args);
	}


	@Value("${server.port}")
	String port ;

	@Autowired
	private EurekaClient discoveryClient;

	@GetMapping("/serviceUrl")
	public String serviceUrl() {
		InstanceInfo instance = discoveryClient.getNextServerFromEureka("EUREKA-CLIENT", false);
		return instance.getHomePageUrl();
	}

	@GetMapping("/test")
	public String hello() {
		return "hello , port :" + port;
	}
}
