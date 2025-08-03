//Problem: return an array of size n+1, where each index in that array is the number of set bits in that index;
//link: https://leetcode.com/problems/counting-bits/
//Source: LeetCode(338)
//Topics: Dynamic Programming
//Diff: Easy - done by soln

public class CountingBits {
    //2ms, 94.16;
    //46.25 MB, 98.98;
    public int[] countBits(int n) {
        int[] nums = new int[n+1];
        if (n == 0) {
            return nums;
        }
        int prev = 0;
        nums[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (nums[i-1] != nums[prev]) {
                nums[i] = nums[i-1];
            }else{
                nums[i] = nums[i-1] + 1;
            }
            prev++;
        }
        return nums;
    }
}
