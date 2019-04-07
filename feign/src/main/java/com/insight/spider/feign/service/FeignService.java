package com.insight.spider.feign.service;

import com.insight.spider.feign.orm.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/29
 * @since: JDK 1.8
 * @version: v1.0
 */
@FeignClient(name = "consumer")
public interface FeignService {

	@RequestMapping(method = RequestMethod.GET, value = "/user/findAll")
	List<User> findAll();

	@PostMapping("/user/insert")
	int insert(User user);
}
