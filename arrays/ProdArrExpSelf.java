//Problem: return an array which is product of each where each number is the product of every other num in array except self.
//link: https://leetcode.com/problems/product-of-array-except-self/
//Source: LeetCode(238)
//Topics: Array
//Diff: Med

import java.util.Arrays;

public class ProdArrExpSelf {
    static int[] prodExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = 1;
        int[] suff = new int[n];
        suff[n-1] = 1;
        for (int i = 1; i < n; i++){
            pre[i] = pre[i-1] * nums[i-1];
        }
        for (int i = n-2; i >= 0; i--) {
            suff[i] = suff[i+1] * nums[i+1];
        }
        for (int i  = 0; i < n; i++) {
            nums[i] = pre[i] * suff[i];
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] x = {1,2,3,4};
        System.out.println(Arrays.toString(prodExceptSelf(x)));
    }
}
