package com.insight.spider.feign.service;

import com.insight.spider.feign.orm.entity.User;
import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/29
 * @since: JDK 1.8
 * @version: v1.0
 */
//@FeignClient(name = "consumer" , fallback = HystrixClientFallBack.class)
//public interface FeignService {
//
//	@RequestMapping(method = RequestMethod.GET, value = "/user/findAll")
//	List<User> findAll();
//
//	//@PostMapping("/user/insert")
//	//int insert(User user);
//
//}
//
//@Component
//class HystrixClientFallBack implements FeignService{
//
//	@Override
//	public List<User> findAll() {
//		User user = new User();
//		user.setId(0);
//		user.setAddress("fallbackAddress");
//		user.setName("fallbackName");
//		List<User> list = new ArrayList<>();
//		list.add(user);
//		return list;
//	}
//}

/**
 * 如果需要访问导致回退触发器的原因，采用下面的这种方式实现
 */
@FeignClient(name = "consumer", fallbackFactory =HystrixClientFallBack.class)
public interface FeignService {

	@RequestMapping(method = RequestMethod.GET, value = "/user/findAll")
	List<User> findAll();

	//@PostMapping("/user/insert")
	//int insert(User user);

}

@Component
class HystrixClientFallBack implements FallbackFactory<FeignService> {

	//@Override
	//public List<User> findAll() {
	//	User user = new User();
	//	user.setId(0);
	//	user.setAddress("fallbackAddress");
	//	user.setName("fallbackName");
	//	List<User> list = new ArrayList<>();
	//	list.add(user);
	//	return list;
	//}

	@Override
	public FeignService create(Throwable throwable) {
		return () -> {
			User user = new User();
			user.setId(0);
			user.setAddress("fallbackAddress");
			user.setName("fallbackCause :" + throwable.getMessage());
			List<User> list = new ArrayList<>();
			list.add(user);
			return list;
		};
	}
}
