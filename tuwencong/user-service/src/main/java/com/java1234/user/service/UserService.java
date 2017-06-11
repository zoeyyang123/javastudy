package com.java1234.user.service;

import com.java1234.user.entity.News;
import com.java1234.user.entity.User;

import java.util.List;

/**
 * 用户Service接口
 * @author Administrator
 *
 */
public interface UserService {

	public User login(User user);
	public List<News> acquireNews (String table, Integer n);
}
