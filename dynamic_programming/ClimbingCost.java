//Problem: find the min cost to climb a staur
//link: https://leetcode.com/problems/min-cost-climbing-stairs/?envType=problem-list-v2&envId=dynamic-programming
//Source: LeetCode(746)
//Topics: Dynamic Programming
//Diff: Easy-done with soln

public class ClimbingCost {
    public int minCostClimbingStairs(int[] cost) {
        //best time;
        //43.62 MB, beats 13.4;
        int[] min = new int[cost.length+1];
        min[0] = 0;
        min[1] = 0;
        for (int i = 2; i <= cost.length; i++) {
            min[i] = Math.min(min[i-1] + cost[i-1], min[i-2] + cost[i-2]);
        }
        return min[cost.length];
    }
}
