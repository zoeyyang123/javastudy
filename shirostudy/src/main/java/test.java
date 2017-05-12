import java.util.Scanner;

/**
 * Created by zhaoyi on 17-5-11.
 */

public class test {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            System.out.println("i="+i);
        }
        float j = 0.1f;
        System.out.println("j="+j);
        float maxf  =  Float.MAX_VALUE;
        System.out.println("maxf="+maxf);
        Scanner scanner = new Scanner(System.in);
        int next = scanner.nextInt();
        System.out.println("next="+next);
        for (int i = 1; i <= next; i++) {
            System.out.print(i+" ");
        }
    }

}
