package com.insight.spider.eurakaserver.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.io.Serializable;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/4/3
 * @since: JDK 1.8
 * @version: v1.0
 */

//@ConfigurationProperties("spring.data")
public class Person implements Serializable {

	private String name ;
	private int age ;
	private String address;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", age=" + age +
				", address='" + address + '\'' +
				'}';
	}
}
