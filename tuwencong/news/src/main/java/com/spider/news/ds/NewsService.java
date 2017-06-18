package com.spider.news.ds;

import com.spider.news.entity.NewsBasic;

import java.util.List;

/**
 * Created by zhaoyi on 17-6-17.
 */
public interface NewsService {
    public List<NewsBasic> acquireNews (String table, Integer n);
}
