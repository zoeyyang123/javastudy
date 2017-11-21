package LittleTest;

/**
 * Created by zhaoyi on 17-11-16.
 */
public class Test2 {
    public static void main(String[] args) {
        int a = 50000000;
        int b = 20;
        int sum = 0;
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                sum++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("over sum = "+sum);
        System.out.println("小数字在外层，大数字在内层总时间（ms） = " + (endTime-startTime));

        sum = 0;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < b; i++) {
            for (int j = 0; j < a; j++) {
                sum++;
            }
        }
        endTime = System.currentTimeMillis();
        System.out.println("over sum = "+sum);
        System.out.println("大数字在外层，小数字在内层总时间（ms） = " + (endTime-startTime));
    }
}
