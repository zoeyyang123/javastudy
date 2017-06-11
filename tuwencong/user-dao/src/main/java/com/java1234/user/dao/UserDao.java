package com.java1234.user.dao;

import com.java1234.user.entity.News;
import com.java1234.user.entity.User;

/**
 * 用户DAO接口
 * @author Administrator
 *
 */
public interface UserDao {

	public User login(User user);
	public void createUser(User user);
	public News acquireFintecNews (Integer n);
	public void createNews(News news);
}
