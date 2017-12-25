package thread;

/**
 * SuspendAndResumeTest class
 * 模拟了在suspend前就误将resume操作使用了的错误结果
 * @author zhaoyi
 * @date 17-12-6
 */
public class SuspendAndResumeTest {
    public static Object u = new Object();
    static ChangeObjectThread t1 = new ChangeObjectThread("t1");
    static ChangeObjectThread t2 = new ChangeObjectThread("t2");

    public static class ChangeObjectThread extends Thread{
        public ChangeObjectThread(String name){
            super.setName(name);
        }

        @Override
        public void run() {
            synchronized (u){
                System.out.println("in "+ getName());//getName方法 是Thread的static方法
                Thread.currentThread().suspend();//已经废弃了，但是为了测试
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        t1.start();
        Thread.sleep(100);
        t2.start();
        t1.resume();
        t2.resume();
        t1.join();
        t2.join();
    }
}
