//Problem: given an array of length n and numbers in range 0 to n-1 where one number is missing find that number
//link: https://leetcode.com/problems/missing-number/
//Source: LeetCode(268)
//Topics: Bit Manipulation
//Diff: Easy


import java.util.Arrays;

public class MissingNumber {
    static int naive(int[] nums) {
        //5ms, 25.1;
        //45.49 MB, 43.38;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return nums.length;
    }

    static int optimised(int[] nums) {
        //0ms, best;
        //45.4 MB, 56.41;
        int n = nums.length;
        int sum = n*(n+1)/2;
        for (int i : nums) {
            sum -= i;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,8,1};
        System.out.println(optimised(nums));
    }
}
