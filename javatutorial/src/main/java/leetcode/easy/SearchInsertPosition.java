package leetcode.easy;

/**
 * Created by zhaoyi on 17-7-6.
 */
public class SearchInsertPosition {
    public static int searchInsert(int[] nums, int target) {
        /*int right = nums.length-1;
        int left = 0;
        int mid = 0;
        if (target<=nums[left]) return left;
        if (target>nums[right]) return right+1;
        if (target==nums[right]) return right;
        while (left!=right&&(right-left)!=1){
            mid = (left+right)/2;
            if (target==nums[mid])
                return mid;
            else if (target>nums[mid]){
                left = mid;
            }
            else{
                right = mid;
            }
        }
        return target>nums[mid]?(mid+1):mid;*/
        //自己写的二分法


        /*int numSize = nums.length;
        for (int i = 0; i < numSize; i++) {
            if (target<=nums[i]) return i;
        }
        return numSize;*/
        //直接查找法


        int low = 0, high = nums.length-1;
        while(low<=high){
            int mid = (low+high)/2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] > target) high = mid-1;
            else low = mid+1;
        }
        return low;
        //网上的二分法
    }

    public static void main(String[] args) {
        int[] nums = {1};
        System.out.println(searchInsert(nums,2));
    }
}
