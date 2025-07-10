//Problem: given a (n,n) matrix and starting point(0,0) the rat has to reach (n-1,n-1) and mark down its path; the maze
//         has cells representing 0 and 1. 0 means block cell.
//link: https://www.geeksforgeeks.org/dsa/rat-in-a-maze/
//Source: GFG
//Topics: BackTracking
//Diff: Med

import java.util.ArrayList;
import java.util.PropertyResourceBundle;
import java.util.regex.Pattern;

public class RatInMaze {
    static boolean validCell(int row, int col, int n, int[][] maze) {
            return row >= 0 && col >= 0 && row < n && col < n && maze[row][col] == 1;
    }

    static ArrayList<Character> sol(int[][] maze, int row, int col, ArrayList<Character> path) {
        int n = maze.length;
        if (row == n-1 && col == n-1) {
            return path;
        }
        System.out.println("row:"+row);
        System.out.println("col:"+col);
        System.out.println();
        maze[row][col] = 0;
        if (validCell(row, col + 1, n, maze)) {
            path.add('R');
            sol(maze, row, col + 1, path);
        }
        if (validCell(row + 1, col, n, maze)) {
            path.add('D');
            sol(maze, row + 1, col, path);
        }
        if (validCell(row, col - 1, n, maze)){
            path.add('L');
            sol(maze, row, col - 1, path);
        }
        if (validCell(row - 1, col, n, maze)) {
            path.add('U');
            sol(maze, row - 1, col, path);
        }
        maze[row][col] = 1;
        return path;
    }
    static void PrintSol(int[][] maze) {
        ArrayList<Character> path = new ArrayList<>();
        System.out.println(sol(maze, 0,0,path));
    }

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,0},
                        {1,1,0,1},
                        {0,1,0,0},
                        {1,1,1,1}};
        PrintSol(maze);
    }
}
