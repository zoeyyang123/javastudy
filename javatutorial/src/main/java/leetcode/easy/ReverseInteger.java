package leetcode.easy;

/**
 * Created by zhaoyi on 17-6-28.
 */
public class ReverseInteger {
    public static int reverse(int x) {
        long j = 0;
        long k = 0;
        long m = x;
        if (m>=0){
            while (m!= 0){
                j=m%10;
                k=k*10+j;
                m=(m-j)/10;
            }
            return k<=Integer.MAX_VALUE?(int)k:0;
        }else {
            m*=-1;
            while (m!= 0){
                j=m%10;
                k=k*10+j;
                m=(m-j)/10;
            }
            k*=-1;
            return k>=Integer.MIN_VALUE?(int)k:0;
        }
    }

    public static void main(String[] args) {
        int x = -1000001009;
        System.out.println(reverse(x));
    }
}
