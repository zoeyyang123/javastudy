package com.spider.news.autorun;

import com.spider.news.ds.NewsService;

import java.util.Timer;

public class TestTimerManager {
    //新建一个定时器
    Timer timer = new Timer(true);

    public TestTimerManager(NewsService newsService) {
        super();
        //新建一个定时任务

        Spider task = new Spider(newsService);
        //设置定时任务

        timer.schedule(task, 0, 1000*60*5);//延迟10秒，每300秒执行一次
    }
}
