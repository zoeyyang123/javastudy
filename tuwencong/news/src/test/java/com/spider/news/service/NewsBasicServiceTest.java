package com.spider.news.service;

import com.spider.news.dao.NewsDao;
import com.spider.news.ds.NewsService;
import com.spider.news.entity.NewsBasic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by zhaoyi on 17-6-10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class NewsBasicServiceTest {

    @Autowired
    private NewsDao newsDao;
    @Autowired
    private NewsService newsService;

    //@Test
    public void createNews() throws Exception{
        NewsBasic newsBasic = new NewsBasic();
        newsBasic.setDate(new Date());
        newsBasic.setUrl("www.baidu.com");
        newsBasic.setContent("这个是正文");
        newsBasic.setTitle("这个是标题");
        newsBasic.setSource("中国电子银行");

        newsDao.createNews(newsBasic);

    }



    @Test
    public void acquireNews() throws Exception{
        Integer n = 5 ;
        List<NewsBasic> newsBasicBigdata = newsService.acquireNews("news_bigdata",n);
        for (int i = 0; i <n ; i++) {
            System.out.println(newsBasicBigdata.get(i).getTitle());
        }
    }
}
