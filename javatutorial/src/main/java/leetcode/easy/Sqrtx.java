package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-12.
 */
public class Sqrtx {
    public static int mySqrt(int x) {
        if (x==0) return 0;
        if (x>=1&&x<4) return 1;
        if (x>=4&&x<9) return 2;
        int left = 0;
        int right = x/2;
        long mid;
        while ((right-left)>1){
            mid = (left+right)/2;
            if (mid*mid==x) return (int)mid;
            else if(mid*mid<x) left = (int)mid;
            else right = (int)mid;
        }
        return left;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }
}
