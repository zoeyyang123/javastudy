package com.spider.news.service.impl;

import com.spider.news.entity.NewsBigdata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spider.news.dao.NewsDao;
import com.spider.news.service.NewsService;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户Service实现类
 * @author Administrator
 *
 */
@Service
public class NewsServiceImpl implements NewsService {

	@Autowired
	private NewsDao newsDao;
	

	public List<NewsBigdata> acquireNews(String table, Integer n){
		List<NewsBigdata> newsBigdata = new ArrayList<NewsBigdata>(n);
		switch (NewsTable.getTable(table)){
			case  news_bigdata :
				for (int i = 1; i <=n ; i++) {
					newsBigdata.add(newsDao.acquireNews_Bigdata(i));
				}
				break;
		}

		return newsBigdata;
	}

	public enum NewsTable {
		news_bigdata, news_ai, news_blockchain, news_other;

		public static NewsTable getTable(String table) {

			return valueOf(table);
		}
	}

}
