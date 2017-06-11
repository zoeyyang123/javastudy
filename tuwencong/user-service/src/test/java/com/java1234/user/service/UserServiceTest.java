package com.java1234.user.service;

import com.java1234.user.dao.UserDao;
import com.java1234.user.entity.News;
import com.java1234.user.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhaoyi on 17-6-10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserServiceTest {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserService userService;

    //@Test
    public void createNews() throws Exception{
        News news = new News();
        news.setDate(new Date());
        news.setSite("www.baidu.com");
        news.setText("这个是正文");
        news.setTitle("这个是标题");

        userDao.createNews(news);

    }

    //@Test
    public void createUser() throws Exception{
        User user = new User();
        //user.setId(1);
        user.setUserName("dudu");
        user.setPassword("123456");

        userDao.createUser(user);
    }

    @Test
    public void acquireNews() throws Exception{
        Integer n = 5 ;
        List<News> news = userService.acquireNews("FintecNews",n);
        for (int i = 0; i <n ; i++) {
            System.out.println(news.get(i).getTitle());
        }
    }
}
