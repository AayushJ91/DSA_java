//Problem: Finding the sum of largest subarray
//link: https://leetcode.com/problems/maximum-subarray/
//Source: LeetCode-53
//Topics: Arrays
//Diff: Med
//Time: 1ms - beats 99.59
//space: 57.4B - beats 21.46


public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        // nums = {-1, 1}
        // curr sum = -1 + 1 = 0
        // currSum = 0 < nums[1] = 1
        // currSum = 1
        for (int i = 0; i < n; i++) {
            currSum += nums[i];
            if (currSum < nums[i]) {
                currSum = nums[i];
            }
            max = Math.max(currSum, max);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {5,4,-1,7,8};
        System.out.println(maxSubArray(nums));
    }
}
