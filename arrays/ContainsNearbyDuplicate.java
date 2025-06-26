//Problem: finding the nearesr duplicate element within range k
//link: https://leetcode.com/problems/contains-duplicate-ii/?envType=problem-list-v2&envId=sliding-window
//Source: LeetCode (76)
//Topics:
//Diff: Hard

import java.util.ArrayList;

public class ContainsNearbyDuplicate {
    static boolean naive(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != i) {
                    if (nums[j] == nums[i] && Math.abs(i - j) <= k) {
                        return true;
                    }
                }
                System.out.println();
            }
        }
        return false;
    }
    static boolean optimistic(int[] nums, int k) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int j = i + k;
            
        }
        return true;
    }
    public static void main(String[] args) {  
        int[] nums = {1,2,3,1,2,3};
        System.out.println(naive(nums, 2));
    }
}
