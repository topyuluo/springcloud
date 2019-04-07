package com.insight.demo.consumer.service.impl;

import com.insight.demo.consumer.orm.dao.UserMapper;
import com.insight.demo.consumer.orm.entity.User;
import com.insight.demo.consumer.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/28
 * @since: JDK 1.8
 * @version: v1.0
 */

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userDao ;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}

	@Override
	public User findUserById(int id ) {
		return userDao.findUserById(id);
	}

	@Override
	public int insert(User user) {
		return userDao.insert(user);
	}

}
