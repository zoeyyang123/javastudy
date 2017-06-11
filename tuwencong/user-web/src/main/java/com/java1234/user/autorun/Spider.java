package com.java1234.user.autorun;

import java.util.Date;
import java.util.TimerTask;

/**
 * Created by zhaoyi on 17-6-10.
 */
public class Spider extends TimerTask{

    @Override
    public void run() {
        // TODO Auto-generated method stub
        try {
            System.out.println(new Date());//定时打印当前时间
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

}
