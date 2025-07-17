//Problem: given an array where every element appears twice except for one. Find that number;
//link: https://leetcode.com/problems/single-number/
//Source: LeetCode(136)
//Topics: Bit Manipulation
//Diff: Easy

public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res = res ^ nums[i];
        }
        return res;
    }

    public static void main(String[] args) {
        int[] s = {3,4,5,3,4};
        System.out.println(singleNumber(s));
    }
}
