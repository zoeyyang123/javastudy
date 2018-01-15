package thread.chapter3;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * ThreadPoolDemo class
 * 三种线程池 1 定量线程池
 *           2 不定量会自增
 *           3 单个线程
 * @author zhaoyi
 * @date 17-12-25
 */
public class ThreadPoolDemo {
    public static class MyTask implements Runnable{
        @Override
        public void run() {
            System.out.println(System.currentTimeMillis()+":Thread ID:"+Thread.currentThread().getId());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyTask task = new MyTask();
        //ExecutorService es = Executors.newFixedThreadPool(5);
        //ExecutorService es = Executors.newCachedThreadPool();
        ExecutorService es = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            es.submit(task);
        }
    }
}
