//Problem: return the position of element which is known by most of the people.
//link: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
//Source: GFG
//Topics: Stack
//Diff: Med - not done

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class celebrityPerson {
    static int naive(int[][] mat) {
        int row = mat.length;
        int col = mat[0].length;
        int res = -1;
        Stack<Integer> st = new Stack<>();
        int x = 0;
        for (int i = 0; i < col; i++) {
            res = i;
            System.out.println("row:"+i);
            for (int j = 0; j < row; j++) {
                System.out.println("col:"+j);
                System.out.println("val:"+mat[i][j]);
                System.out.println("res:"+res);
                System.out.println();
                if (mat[i][j] != 1) {
                    res = -1;
                    break;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] mat = {{1, 1, 0},
                       {0, 1, 0},
                       {0, 1, 1}};
        System.out.println(naive(mat));
    }
}
