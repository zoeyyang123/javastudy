package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-7.
 */
public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        /*int numSize = nums.length;
        if (numSize==1) return nums[0];
        int maxSum = nums[0];
        for (int i = 0; i < numSize; i++) {
            int sum = 0;
            for (int j = i; j < numSize; j++) {
                sum+=nums[j];
                if (sum>maxSum)
                    maxSum = sum;
            }
        }
        return maxSum;*/
        //O(n*n)shi一样的算法
        /*int currentmaxsum = nums[0];
        int maxsum= nums[0];
        for(int i=1;i<nums.length;i++){
            currentmaxsum = Math.max(currentmaxsum+nums[i],nums[i]);
            maxsum= Math.max(maxsum,currentmaxsum);
        }
        return maxsum;*/
        //O(n)正常算法
        int numSize = nums.length;
        switch (numSize){
            case 1:
                return nums[0];
            case 2:
                return  (nums[0]>0&&nums[1]>0)?(nums[0]+nums[1]):Math.max(nums[0],nums[1]);
            default:
                int currentMaxSum = nums[0];
                int maxSum= nums[0];
                for(int i=1;i<numSize;i++){
                    currentMaxSum = Math.max(currentMaxSum+nums[i],nums[i]);
                    maxSum= Math.max(maxSum,currentMaxSum);
                }
                return maxSum;
        }

    }

    public static void main(String[] args) {
        int[] sums1 = {0,1,2,3,4,5,6};
        int[] sums2 = {5};
        int[] sums3 = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(sums3));
    }
}
