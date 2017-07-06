package leetcode.easy;

import java.util.ArrayList;

/**
 * Created by zhaoyi on 17-6-28.
 */
public class PalindromeNumber {


    public static boolean isPalindrome(int x) {
        if (x<0){
            return false;
        }else if(x==0){
            return true;
        }else {
            ArrayList<Integer> temp = new ArrayList<Integer>();
            int j =0;
            while (x!= 0){
                j=x%10;
                temp.add(x%10);
                x=(x-j)/10;
            }
            int t = temp.size();
            for (int i = 0; i < t; i++) {
                if (temp.get(i)!=temp.get(t-1-i))
                    return false;
            }
            return true;
        }
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(111232111));
    }
}
