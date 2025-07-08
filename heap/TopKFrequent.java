//Problem: return an array of top k frequent elements in the given array;
//link: https://leetcode.com/problems/top-k-frequent-elements/
//Source: LeetCode (347)
//Topics: Heaps
//Diff: Med

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < nums.length; i++) {
            pq.offer(nums[i]);
        }
        return new int[2];
    }

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,2,3};
        System.out.println(Arrays.toString(topKFrequent(nums, 2)));
    }
}
