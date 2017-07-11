package leetcode.easy;

import org.apache.axis.utils.ArrayUtil;

import java.util.ArrayList;

/**
 * Created by zhaoyi on 17-7-11.
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int flag = 0;
        digits[digits.length-1]+=1;
        for (int i = digits.length-1 ; i >=0 ; i--) {
            digits[i]=digits[i]+flag;
            flag = digits[i]/10;
            if (flag==0)
                return digits;
            else
                digits[i]=digits[i]%10;
        }
        int[] result = new int[digits.length+1];
        result[0]=1;
        for (int j = 1; j < digits.length+1 ; j++) {
            result[j]=digits[j-1];
        }
        return result;
    }

    public static void main(String[] args) {
        int[] digits = {9,9,9,9,9,9,9,9};
        int[] result = plusOne(digits);
        for (int i = 0; i < result.length; i++) {
            System.out.print(Integer.toString(result[i])+",");
        }
    }
}
