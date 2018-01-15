package thread.chapter2;

/**
 * HelloworldTest class
 * hello thread
 * @author zhaoyi
 * @date 17-11-30
 */
public class HelloworldTest {
    public static void main(String[] args){
        Thread t1 = new Thread(){
            @Override
            public void run() {
                System.out.println("Hello Thread!");
            }
        };
        t1.start();
    }

}
