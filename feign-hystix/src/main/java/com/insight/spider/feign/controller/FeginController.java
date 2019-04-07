package com.insight.spider.feign.controller;

import com.insight.spider.feign.orm.entity.User;
import com.insight.spider.feign.service.FeignService;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping("/feginHystrix")
public class FeginController {

	@Autowired
	private FeignService feignService;

	@GetMapping("findAll")
	public List<User> findAll() {
		List<User> all = feignService.findAll();
		all.forEach((user) ->{
			System.out.println(user.toString());
		});
		return all;
	}

	//@PostMapping("/user")
	//public int insert(@RequestBody User user) {
	//	return  feignService.insert(user);
	//}

}
