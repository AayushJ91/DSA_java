//Problem: return the Kth largest integer in the given array; not the distinct element
//link: https://leetcode.com/problems/kth-largest-element-in-an-array/
//Source: LeetCode (215)
//Topics: Heaps
//Diff: Med - naive is better

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class KthLargest {
    public static int naive(int[] nums, int k) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        return nums[nums.length-k];
    }

    public static int optimized(int[] nums, int k) {
        //Time: 73 ms, beats 12;
        //Space: 57.5 MB, beats 79;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            list.add(nums[i]);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(list);
        System.out.println(pq);
        int child = 0;
        for (int i = 0; i < nums.length - k; i++) {
            pq.poll();
            System.out.println(pq);
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,5,6,4};
        System.out.println(naive(arr, 4));
    }
}
