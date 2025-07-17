//Problem: given an array of length and numbers in range 1-n where some numbers are missing find those numbers
//link: https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/
//Source: LeetCode(448)
//Topics: Arrays
//Diff: Easy - done by naive

import java.util.*;

public class DisappearedNumbers {
    private static List<Integer> naive(int[] nums) {
        //20ms, 30.93;
        //60.95 MB, 9.98;
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> x = new HashSet<>();
        for (int i : nums) {
            x.add(i);
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!x.contains(i)) {
                res.add(i);
            }
        }
        return res;
    }

    private static List<Integer> optimised(int[] nums) {
        return new ArrayList<>();
    }

    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        System.out.println(naive(nums));
    }
}
