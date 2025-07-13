//Problem: finding the max element in all subarrays of size k in nums
//link: https://leetcode.com/problems/sliding-window-maximum/
//Source: LeetCode (239)
//Topics: sliding window
//Diff: hard - not done (optimized uses deque and I dont know about it)

import java.util.ArrayList;
import java.util.Arrays;

public class maxSlidingWindow {
    static int[] naive(int[] nums, int k) {
        // Time: limit exceeded
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            int max = Integer.MIN_VALUE;
            System.out.println(i);
            for (int j = i; j - i < k; j++){
                System.out.println("j:"+j);
                max = Math.max(nums[j], max);
            }
            System.out.println();
            res[i] = max;
        }
        return res;
    }
    static int[] optimistic(int[] nums, int k) {
        ArrayList<Integer> window = new ArrayList<>();
        int n = nums.length;
        int[] res = new int[n-k+1];
        int st = 0, last = st + k;
        while (st < last) {
            window.add(nums[st]);
            st++;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] fin = {1,3,-1,-3,5,3,6,7};
        System.out.println(Arrays.toString(optimistic(fin,3)));
    }
}
