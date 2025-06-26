//Problem: Two Sum
//link: https://leetcode.com/problems/two-sum/
//Source: LeetCode (1)
//Topics: Arrays, Hashmap
//Diff: Easy

import java.util.*;
public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int n = nums.length;
        Map<Integer, Integer> idx = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int val = nums[i];
            if (idx.containsKey(target - val)) {
                res[0] = i;
                res[1] = idx.get(target - val);
                return res;
            }else {
                idx.put(nums[i], i);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] num = {2,7,11,15};
        System.out.println(Arrays.toString(twoSum(num, 9)));
    }
}