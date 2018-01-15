package thread.chapter3;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * ScheduledExecutorServiceDemo class
 * 两个定时任务
 * 1 scheduleAtFixedRate：从线程的开始时间计时时隔两秒新开线程，如果执行时间多余定时，则以执行时间为准
 * 2 scheduleWithFixedDelay；从线程结束时间开始计时时隔两秒新开线程
 * @author zhaoyi
 * @date 17-12-25
 */
public class ScheduledExecutorServiceDemo {
    public static void main(String[] args) {
        ScheduledExecutorService ses = Executors.newScheduledThreadPool(10);
        ses.scheduleAtFixedRate(new Runnable() {
        //ses.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println(System.currentTimeMillis()/1000);
                    Thread.sleep(new Random().nextInt(4000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },0,2, TimeUnit.SECONDS);
    }
}
