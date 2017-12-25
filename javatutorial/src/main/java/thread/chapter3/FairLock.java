package thread.chapter3;

import java.util.concurrent.locks.ReentrantLock;

/**
 * FairLock class
 *
 * @author zhaoyi
 * @date 17-12-21
 */
public class FairLock implements Runnable {
    public static ReentrantLock fairLock = new ReentrantLock(true);

    @Override
    public void run() {
        while (true){
            try {
                fairLock.lock();
                System.out.println(Thread.currentThread().getName()+"获得锁");
                //Thread.sleep(500);
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                fairLock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        FairLock r1 = new FairLock();
        Thread t1 = new Thread(r1,"Thread_t1");
        Thread t2 = new Thread(r1,"Thread_t2");
        t1.start();
        t2.start();
    }
}
