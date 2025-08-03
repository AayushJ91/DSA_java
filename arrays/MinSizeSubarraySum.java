//Problem: return the minimal length of a subarray whose sum is greater than or equal to target
//link: https://leetcode.com/problems/minimum-size-subarray-sum/
//Source: LeetCode (209)
//Topics: Sliding Window
//Diff: Med - done by soln

public class MinSizeSubarraySum {
    //1ms, 99.69;
    //58.16 MB, 53;
    static int naive(int target, int[] nums) {
        int res = Integer.MAX_VALUE;
        int i = 0, j = 0;
        int sum = 0;
        while (i < nums.length) {
            sum += nums[i];
            while (sum >= target) {
                sum -= nums[j];
                res = Math.min(res, i-j+1);
                j++;
            }
            i++;
        }
        if (res == Integer.MAX_VALUE) {
            res = 0;
        }
        return res;
    }
}
