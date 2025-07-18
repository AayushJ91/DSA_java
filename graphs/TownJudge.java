//Problem: given a matrix where each array is a,b where a trusts be. Find the element which trusts nobody;
//link: https://leetcode.com/problems/find-the-town-judge/
//Source: LeetCode(997)
//Topics: graph
//Diff: Easy

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TownJudge {
    public static int findJudge(int n, int[][] trust) {
        List<List<Integer>> trustee = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            trustee.add(new ArrayList<>());
        }
        for (int[] curr : trust) {
            trustee.get(curr[0] - 1).add(curr[1]);
        }
        System.out.println(trustee);
        for (int i = 0; i < n; i++) {
            List<Integer> curr = trustee.get(i);
            if (curr.isEmpty()) {
                return i+1;
            }
        }
        return -1;
    }

    static int opt(int n, int[][] trust) {
        int[] count = new int[n+1];
        for (int[] t: trust) {
            count[t[0]]--;
            count[t[1]]++;
        }
        for (int i = 1; i <= n; ++i) {
            if (count[i] == n - 1) return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[][] trust = {{1,2}, {2,3}};
        System.out.println(findJudge(3, trust));
    }
}