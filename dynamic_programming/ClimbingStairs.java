//Problem: find in how many ways we can climb the stairs
//link: https://leetcode.com/problems/min-cost-climbing-stairs/
//Source: LeetCode(70)
//Topics: Dynamic Programming
//Diff: Easy

public class ClimbingStairs {
    static int tabul(int n) {
        //best time
        //best
        if (n == 1) {
            return 1;
        }
        if (n == 0) {
            return 0;
        }
        int [] stairs = new int[n+1];
        stairs[0] = 1;
        stairs[1] = 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = stairs[i-1] + stairs[i-2];
            stairs[i] = f;
        }
        return stairs[n];
    }

    public static void main(String[] args) {
        System.out.println(tabul(6));
    }
}
