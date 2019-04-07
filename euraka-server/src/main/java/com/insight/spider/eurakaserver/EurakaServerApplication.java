package com.insight.spider.eurakaserver;

import com.insight.spider.eurakaserver.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

@EnableEurekaServer
@SpringBootApplication
public class EurakaServerApplication {


	@Bean
	@ConfigurationProperties(prefix = "spring.data")
	public Person getPerson() {
		return new Person();
	}

	private static Person person;

	@Autowired
	public void setPerson(Person person) {
		EurakaServerApplication.person = person;
	}


	public static void main(String[] args) {
		SpringApplication.run(EurakaServerApplication.class, args);

		//System.out.println(person.toString());
		//System.out.println(person.getName());
	}

}
