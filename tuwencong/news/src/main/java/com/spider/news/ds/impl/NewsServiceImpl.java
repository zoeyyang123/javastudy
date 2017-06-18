package com.spider.news.ds.impl;

import com.spider.news.dao.NewsDao;
import com.spider.news.ds.NewsService;
import com.spider.news.entity.NewsBasic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaoyi on 17-6-17.
 */
@Service
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsDao newsDao;


    public List<NewsBasic> acquireNews(String table, Integer n){
        List<NewsBasic> newsBasicBigdata = new ArrayList<NewsBasic>(n);
        switch (NewsTable.getTable(table)){
            case  news_bigdata :
                for (int i = 1; i <=n ; i++) {
                    newsBasicBigdata.add(newsDao.acquireNews_Bigdata(i));
                }
                break;
            case news_ai:
                for (int i = 1; i <=n ; i++) {
                    newsBasicBigdata.add(newsDao.acquireNews_Ai(i));
                }
                break;
            case news_other:
                for (int i = 1; i <=n ; i++) {
                    newsBasicBigdata.add(newsDao.acquireNews_Other(i));
                }
                break;
            case news_blockchain:
                for (int i = 1; i <=n ; i++) {
                    newsBasicBigdata.add(newsDao.acquireNews_Blockchain(i));
                }
                break;
        }

        return newsBasicBigdata;
    }

    public enum NewsTable {
        news_bigdata, news_ai, news_blockchain, news_other;

        public static NewsTable getTable(String table) {

            return valueOf(table);
        }
    }
}
