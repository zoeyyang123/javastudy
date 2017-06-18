package com.spider.news.dao;

import com.spider.news.entity.NewsBasic;
import org.springframework.stereotype.Service;


/**
 * 用户DAO接口
 * @author Administrator
 *
 */
@Service
public interface NewsDao {

	public NewsBasic acquireNews_Bigdata (Integer n);
	public NewsBasic acquireNews_Ai (Integer n);
	public NewsBasic acquireNews_Other (Integer n);
	public NewsBasic acquireNews_Blockchain (Integer n);
	public void createNews(NewsBasic newsBasic);
}
