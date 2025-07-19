//Problem: Calculate the sum of the elements of nums between indices left and right inclusive where left <= right.
//link: https://leetcode.com/problems/ange-sum-query-immutable/
//Source: LeetCode(303)
//Topics: Dynamic Programming
//Diff: Easy

public class RangeSumQuery {
    //8ms; 53.64;
    //49.58 MB; 42.36;
    int[] nums;
    public void NumArray(int[] nums) {
        for(int i=1;i<nums.length; i++){
            nums[i] += nums[i-1];
        }
        this.nums = nums;
    }

    public int sumRange(int left, int right) {
        if(left ==0)
            return nums[right];

        return nums[right] - nums[left-1];
    }
}
