package com.spider.news.autorun;

import com.spider.news.ds.NewsService;
import com.spider.news.entity.NewsBasic;

import org.python.jline.internal.InputStreamReader;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.util.*;

/**
 * Created by zhaoyi on 17-6-10.
 */
public class Spider extends TimerTask{
    @Autowired
    private NewsService newsService;
    public Spider(NewsService newsService) {
        super();
        this.newsService = newsService;
    }


    public static HashMap allNews = new HashMap();
    @Override
    public void run() {

        try {
            String filePath =  Thread.currentThread().getContextClassLoader().getResource("news.py").getPath();
            System.out.println("start");
            Process pr = Runtime.getRuntime().exec("python "+filePath);
            InputStreamReader x = new InputStreamReader(pr.getInputStream());

            BufferedReader in = new BufferedReader(new InputStreamReader(pr.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();

            pr.waitFor();
            System.out.println("end");
        }catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        // TODO Auto-generated method stub
        try {
            System.out.println(new Date());//定时打印当前时间
            List<NewsBasic> bigDataNews= newsService.acquireNews("news_bigdata",5);
            List<NewsBasic> aiNews= newsService.acquireNews("news_ai",5);
            List<NewsBasic> blockChainNews= newsService.acquireNews("news_blockchain",5);
            List<NewsBasic> otherNews= newsService.acquireNews("news_other",5);
            for (int i = 0; i < 5 ; i++) {
                allNews.put("news_bigdata"+i,bigDataNews.get(i));
                allNews.put("news_ai"+i,aiNews.get(i));
                allNews.put("news_blockchain"+i,blockChainNews.get(i));
                allNews.put("news_other"+i,otherNews.get(i));
            }

        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
