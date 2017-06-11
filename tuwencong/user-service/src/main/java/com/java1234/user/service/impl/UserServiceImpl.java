package com.java1234.user.service.impl;

import com.java1234.user.entity.News;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java1234.user.dao.UserDao;
import com.java1234.user.entity.User;
import com.java1234.user.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Service实现类
 * @author Administrator
 *
 */
@Service("userService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	public User login(User user) {
		return userDao.login(user);
	}
	public List<News> acquireNews(String table, Integer n){
		List<News> news = new ArrayList<News>(n);
		switch (NewsTable.getTable(table)){
			case  FintecNews :
				for (int i = 1; i <=n ; i++) {
					news.add(userDao.acquireFintecNews(i));
				}
				break;
		}

		return news;
	}

	public enum NewsTable {
		FintecNews, BlockChainNews;

		public static NewsTable getTable(String table) {

			return valueOf(table);
		}
	}

}
