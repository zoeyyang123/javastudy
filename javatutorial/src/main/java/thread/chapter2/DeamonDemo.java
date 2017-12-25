package thread.chapter2;

/**
 * DeamonDemo class
 * 设置线程为守护线程，setDaemon(true),当用户线程全部结束，意味着该线程也无事可做，
 * 其守护的内容已经没有了，整个应用程序应该自然而然的结束，所以当Java应用内只有守护线程的时候，虚拟机会自动退出
 * @author zhaoyi
 * @date 17-12-14
 */
public class DeamonDemo {
    public static class DaemonT extends Thread{
        @Override
        public void run() {
            while (true){
                System.out.println("I'm alive");
                try {
                    Thread.sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new DaemonT();
        //t.setDaemon(true);
        t.start();

        Thread.sleep(2000);
    }
}
