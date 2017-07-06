package leetcode.hard;

/**
 * Created by zhaoyi on 17-6-28.
 */
public class MedianofTwoSortedArrays {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        if (m==0&&n!=0){
            return n%2!=0?nums2[n/2]:(nums2[n/2]+nums2[n/2-1])/2.0;
        }else if (n==0&&m!=0){
            return m%2!=0?nums1[m/2]:(nums1[m/2]+nums1[m/2-1])/2.0;
        }else if (n!=0&&m!=0){
            if (m>n){
                //这个太他妈难，等我80级回来再弄你
            }
        }
        return 0;
    }
}
