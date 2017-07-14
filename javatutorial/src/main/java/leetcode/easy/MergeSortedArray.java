package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-13.
 */
public class MergeSortedArray {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m+n-1;
        while (n!=0&&m!=0){
            if (nums1[m-1]>nums2[n-1]){
                nums1[i]=nums1[m-1];
                m--;
            }else{
                nums1[i]=nums2[n-1];
                n--;
            }
            i--;
        }
        if (n>0){
            while (n>0){
                nums1[i]=nums2[n-1];
                n--;
                i--;
            }
        }
    }
    public static int[] num1 = new int[10];
    public static void main(String[] args) {
        num1[0]=1;
        num1[1]=2;
        num1[2]=3;
        int[] num2 = new int[2];
        num2[0]=5;
        num2[1]=6;
        merge(num1,3,num2,2);
        for (int i = 0; i < 10 ; i++) {
            System.out.println(num1[i]);
        }
    }
}
