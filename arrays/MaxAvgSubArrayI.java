//Problem: find the maximum average sum among subarrays of length k;
//link: https://leetcode.com/problems/maximum-average-subarray-i/
//Source: LeetCode (643)
//Topics: Sliding Window
//Diff: Easy

public class MaxAvgSubArrayI {
    //4ms, 63.69;
    //52.26 MB, 65.29;
    static double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        double res = (double) sum/k;
        for (int i = 1; i <= n-k; i++) {
            sum -= nums[i-1];
            sum += nums[i+k-1];
            // if ((double) sum/k > res) {
            //     res = (double) sum/k;
            // }
            res = Math.max(res, (double) sum/k);
        }
        return res;
    }
}
