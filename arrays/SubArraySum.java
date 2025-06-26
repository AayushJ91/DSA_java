//Problem: Sub Array sum equals k
//link: https://leetcode.com/problems/subarray-sum-equals-k/
//Source: LeetCode-560
//Topics: Arrays, HashMap, prefixSum
//Diff: Med
//Time: 19ms - 98.97
//space: 47.85MB - 5.17


import java.util.HashMap;

class SubArraySum {
    static int subarraySum(int[] nums, int k) {
        int n = nums.length, res = 0;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (prefix[i] == k) {
                //agar i tak sum is equal to k
                res++;
            }
            if (map.containsKey(prefix[i] - k)) {
                //checking the subarrays
                res += map.get(prefix[i] - k);
            }
            map.put(prefix[i], map.getOrDefault(prefix[i], 0) + 1);
            //adding sum and freq to the hashmap
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {1,1,2,5};
        System.out.println(subarraySum(nums, 7));
    }
}
