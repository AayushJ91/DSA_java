//Problem: give the h-Index
//link: https://leetcode.com/problems/invert-binary-tree/
//Source: LeetCode(274)
//Topics: Arrays
//Diff: Med-not done

import java.util.Arrays;
import java.util.Map;

public class H_Index {
    public static int hIndex(int[] citations) {
        if (citations.length == 1) {
            return citations[0];
        }
        int n = citations.length;
        Arrays.sort(citations);
        for (int i = n - 1; i >=0; i--) {
            if (n-i >= citations[i]) {
                return citations[i];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] x = {1,3,1};
        System.out.println(hIndex(x));
    }
}
