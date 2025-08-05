//Problem: reshape the given matrix into the given dimensions
//link: https://leetcode.com/problems/reshape-the-matrix/
//Source: LeetCode (566)
//Topics: Arrays
//Diff: Easy

import java.util.ArrayList;
import java.util.List;

public class ReshapeMatrix {
    //1ms, 66.59;
    //45.43 MB, 59.89;
    static int[][] naive(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (m*n != r*c) {
            return mat;
        }
        int[][] res = new int[r][c];
        int[] lis = new int[m*n];
        int idx = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                lis[idx++] = mat[i][j];
            }
        }
        idx = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                res[i][j] = lis[idx++];
            }
        }
        return res;
    }
    static int[][] optimized(int[][] mat, int r, int c) {
        //best - done by soln
        int m = mat.length;
        int n = mat[0].length;
        if (m*n != r*c) {
            return mat;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < m*n; i++) {
            mat[i/n][i%n] = res[i/c][i%c];
        }
        return res;
    }
}
