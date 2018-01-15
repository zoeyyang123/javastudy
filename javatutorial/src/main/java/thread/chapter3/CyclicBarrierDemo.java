package thread.chapter3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierDemo class
 * 循环栅栏，cyclic说明是有循环作用，假设我们将计数器设置为10，那么凑齐10个第一批的线程，
 * 计数器归零，可以重新使用
 * @author zhaoyi
 * @date 17-12-25
 */
public class CyclicBarrierDemo {
    public static class Soldier implements Runnable{
        private String soldier;
        private final CyclicBarrier cyclic;

        Soldier(String soldierName, CyclicBarrier cyclic) {
            this.soldier = soldierName;
            this.cyclic = cyclic;
        }

        @Override
        public void run() {
            try {
                //等待所有士兵到齐
                cyclic.await();
                doWork();
                cyclic.await();
            } catch (InterruptedException e) {

            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        void doWork(){
            try {
                Thread.sleep(Math.abs(new Random().nextInt()%10000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(soldier+"：任务完成");
        }
    }
    public static class BarrierRun implements Runnable{
        boolean flag;
        int N;
        public BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if (flag){
                System.out.println("司令：[士兵"+N+"个,任务完成！]");
            }else {
                System.out.println("司令：[士兵"+N+"个,集合完毕！]");
                flag=true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclic = new CyclicBarrier(N,new BarrierRun(flag,N));
        //设置屏障点，主要是为了执行这个方法
        System.out.println("集合队伍！");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵"+i+"报到！");
            allSoldier[i]=new Thread(new Soldier("士兵"+i,cyclic));
            allSoldier[i].start();
            if (i==5){
                allSoldier[0].interrupt();
            }
        }
    }

}
