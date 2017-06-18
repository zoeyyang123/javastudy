package com.spider.news.service;

import com.spider.news.dao.NewsDao;
import com.spider.news.entity.NewsBigdata;
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
public class NewsServiceTest {

    @Autowired
    private NewsDao newsDao;
    @Autowired
    private NewsService newsService;

    //@Test
    public void createNews() throws Exception{
        NewsBigdata newsBigdata = new NewsBigdata();
        newsBigdata.setDate(new Date());
        newsBigdata.setUrl("www.baidu.com");
        newsBigdata.setContent("这个是正文");
        newsBigdata.setTitle("这个是标题");
        newsBigdata.setSource("中国电子银行");

        newsDao.createNews(newsBigdata);

    }



    @Test
    public void acquireNews() throws Exception{
        Integer n = 5 ;
        List<NewsBigdata> newsBigdata = newsService.acquireNews("news_bigdata",n);
        for (int i = 0; i <n ; i++) {
            System.out.println(newsBigdata.get(i).getTitle());
        }
    }
}
