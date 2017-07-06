package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-6.
 */
public class RemoveElement {
    public static int removeElement(int[] nums, int val) {
        int numSize = nums.length;
        if (numSize==0) return numSize;
        else {
            int cnt = 0;
            for (int i = 0; i < numSize; i++) {
                if (val==nums[i]){
                    cnt++;
                }else {
                    nums[i-cnt]=nums[i];
                }
            }
            return (numSize-cnt);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(removeElement(nums,1));
    }
}
