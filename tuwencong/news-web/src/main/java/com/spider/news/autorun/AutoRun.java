package com.spider.news.autorun;

import com.spider.news.ds.NewsService;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.HashSet;
import java.util.Timer;

/**
 * Created by zhaoyi on 17-6-10.
 */
public class AutoRun implements ServletContextListener {
    private Timer timer = null;


    public void contextInitialized(ServletContextEvent arg0) {
        //获得Spring容器
        WebApplicationContext ctx = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
        //从Spring容器中获得SelectDataServlet的实例
        NewsService newsService = ctx.getBean(NewsService.class);
        // TODO Auto-generated method stub
        new TestTimerManager(newsService);

    }

    public AutoRun() {
        super();
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        timer.cancel();
    }
}

