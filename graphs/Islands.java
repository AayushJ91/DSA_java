//Problem: given a grid containing '1' and '0'. find the number of islands.
//link: https://leetcode.com/problems/number-of-islands/
//Source: LeetCode(200)
//Topics: Graphs
//Diff: Med

import java.util.ArrayList;
import java.util.Arrays;

public class Islands {
    public static int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int islands = 0;
        int rows = grid.length, cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1'){
                    dfs(grid, i, j, rows, cols);
                    islands++;
                }
            }
        }
        return islands;
    }
    static void dfs(char[][] grid, int i, int j, int rows, int cols){
        if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0' || grid[i][j] == 'v') return;

        grid[i][j] = 'v';
        dfs(grid, i+1, j, rows, cols);
        dfs(grid, i, j+1, rows, cols);
        dfs(grid, i-1, j, rows, cols);
        dfs(grid, i, j-1, rows, cols);
    }

    public static void main(String[] args) {
        char[][] grid = {{'1','1','1','1','0'},
                         {'1','1','0','1','0'},
                         {'1','1','0','0','0'},
                         {'0','0','0','0','1'}};
        System.out.println(numIslands(grid));
    }
}
