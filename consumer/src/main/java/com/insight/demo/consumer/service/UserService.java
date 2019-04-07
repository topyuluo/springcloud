package com.insight.demo.consumer.service;

import com.insight.demo.consumer.orm.entity.User;

import java.util.List;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/28
 * @since: JDK 1.8
 * @version: v1.0
 */

public interface UserService {
	List<User> findAll();

	User findUserById(int id );

	int insert(User user);
}
