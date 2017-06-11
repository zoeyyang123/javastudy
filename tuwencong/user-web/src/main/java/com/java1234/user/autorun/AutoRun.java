package com.java1234.user.autorun;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;

/**
 * Created by zhaoyi on 17-6-10.
 */
public class AutoRun implements ServletContextListener {
    private Timer timer = null;

    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        timer=new Timer(true);
        timer.schedule(new Spider(),0,1000*3);//延迟0秒，每3秒执行一次DisplayDate()
    }

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        timer.cancel();
    }
}
