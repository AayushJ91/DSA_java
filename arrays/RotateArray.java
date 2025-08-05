//Problem: Rotate the array k times
//link: https://leetcode.com/problems/rotate-array/
//Source: LeetCode (189)
//Topics: Arrays
//Diff: Easy

public class RotateArray {
    //2ms, 25.47;
    static int[] naive(int[] nums, int k) {
        int n = nums.length;
        if (k == n || k % n == 0) {
            return nums;
        }
        k %= n;
        int[] help = new int[k];
        for (int i = 0; i < k; i++) {
            help[i] = nums[n-k+i];
        }
        int last = n-1, exp = n-k-1;
        while (exp >= 0) {
            nums[last] = nums[exp];
            exp--; last--;
        }
        return nums;
    }

    //0ms
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k %= n;
        reverse(nums, 0, n-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, n-1);
    }
    private void reverse(int[] nums, int start, int last) {
        while (start < last) {
            int temp = nums[last];
            nums[last] = nums[start];
            nums[start] = temp;
            start++;last--;
        }
    }
}
