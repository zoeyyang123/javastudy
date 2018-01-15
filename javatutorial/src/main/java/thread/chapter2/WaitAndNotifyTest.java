package thread.chapter2;

/**
 * WaitAndNotifyTest class
 *
 * @author zhaoyi
 * @date 17-11-30
 */
public class WaitAndNotifyTest {
    final static Object object = new Object();
    public static class T1 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ":T1 Start!! ");
                try {
                    System.out.println(System.currentTimeMillis() + ":T1 wait for object ");
                    object.wait();
                    System.out.println("在这里干一些需要object的事情");
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                System.out.println(System.currentTimeMillis() + ":T1 End!! ");
            }
        }
    }
    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized (object){
                System.out.println(System.currentTimeMillis() + ":T2 Start!! notify one thread");
                object.notify();
                System.out.println(System.currentTimeMillis() + ":T2 End!! ");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new T1();
        Thread t2 = new T2();
        t1.start();
        t2.start();
    }
}
