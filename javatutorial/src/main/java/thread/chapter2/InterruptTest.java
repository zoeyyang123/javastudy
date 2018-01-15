package thread.chapter2;


/**
 * InterruptTest class
 * 测试中断
 * @author zhaoyi
 * @date 17-11-30
 */
public class InterruptTest {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(){
            @Override
            public void run(){
                while (true){
                    if (Thread.currentThread().isInterrupted()){
                        System.out.println("interrupted!!");
                        break;
                    }
                    try {
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        System.out.println("在睡眠时中断了！");
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }

}
