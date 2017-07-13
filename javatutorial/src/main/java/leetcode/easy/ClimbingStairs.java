package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-13.
 */
public class ClimbingStairs {
    /*private static int climbStairs(int n){
        if (n<=0)
            return 0;
        else if (n==1)
            return 1;
        else if (n==2){
            return 2;
        }else {
            return climbStairs(n-2)+climbStairs(n-1);
        }
    }*/
    private static int climbStairs(int n){
        if (n<=0)
            return 0;
        else if (n==1)
            return 1;
        else if (n==2){
            return 2;
        }else {
            int[] result = new  int[n];
            result[0]=1;
            result[1]=2;
            for (int i = 2; i < n; i++) {
                result[i]=result[i-1]+result[i-2];
            }
            return result[n-1];
        }
    }
    //循环多次尽量不用递归

    public static void main(String[] args) {
        System.out.println(climbStairs(45));
    }
}
