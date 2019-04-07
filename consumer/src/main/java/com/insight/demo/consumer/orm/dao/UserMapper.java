package com.insight.demo.consumer.orm.dao;

import com.insight.demo.consumer.orm.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * describe
 *
 * @author: YuLuo
 * @date: 2019/3/28
 * @since: JDK 1.8
 * @version: v1.0
 */


@Repository
@Mapper
public interface UserMapper {

	List<User> findAll();

	User findUserById(int id);

	int insert(User user);
}
