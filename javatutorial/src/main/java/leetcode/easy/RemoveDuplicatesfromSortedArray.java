package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-6.
 */
public class RemoveDuplicatesfromSortedArray {
    public static int removeDuplicates(int[] nums) {
        int numSize = nums.length;
        if (numSize==0||numSize==1) return numSize;
        else {
            int result = 0;
            for (int i = 1; i < numSize; i++) {
                if (nums[i]>nums[i-1]){
                    result++;
                    nums[result]=nums[i];
                }
            }
            return (result+1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,7,9,10,10};
        System.out.println(removeDuplicates(nums));
    }
}
