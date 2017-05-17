package tutorial3;

/**
 * Created by zhaoyi on 17-5-15.
 */
public class Eat extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                Thread.sleep(1000);
                System.out.println("吃饭");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
