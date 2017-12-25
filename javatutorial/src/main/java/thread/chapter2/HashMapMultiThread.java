package thread.chapter2;

import java.util.HashMap;
import java.util.Map;


/**
 * ArrayListMultiThread class
 * Java8以后hashmap已经做了大幅更改，不会出现类似问题，但是也非线程安全的，尽量不要用
 * @author zhaoyi
 * @date 17-12-20
 */
public class HashMapMultiThread {
    static Map<String,String> map = new HashMap<String, String>();
    public static class AddThread implements Runnable{
        int start = 0;
        public AddThread(int start){
            this.start=start;
        }
        @Override
        public void run() {
            for (int i = start; i < 100000; i+=2) {
                map.put(Integer.toString(i),Integer.toBinaryString(i));
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(new AddThread(0));
        Thread t2 = new Thread(new AddThread(1));
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(map.size());
    }
}
