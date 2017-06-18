package com.spider.news.service;

import com.spider.news.entity.NewsBigdata;

import java.util.List;

/**
 * 用户Service接口
 * @author Administrator
 *
 */
public interface NewsService {

	public List<NewsBigdata> acquireNews (String table, Integer n);
}
