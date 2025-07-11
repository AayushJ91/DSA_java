//Problem: given an array exit where exit[i] depicts the exit node of i.
//         we have to return the index where the sum of exited indices is max. Maximum Weight node
//link: https://www.geeksforgeeks.org/problems/maximum-weight-node--170645/1?page=1&category=Graph&sortBy=difficulty
//Source: gfg
//Topics: Graphs
//Diff: Easy

import java.util.ArrayList;
import java.util.List;

public class WeightOfMaze {
    public static int maxWeightCell(int[] exits) {
        int n = exits.length;
        List<List<Integer>> matrix = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            matrix.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            if (exits[i] != -1){
                matrix.get(exits[i]).add(i);
            }
        }
        int result = 0;
        int max = -2;
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int x : matrix.get(i)){
                System.out.println("x:"+x);
                sum += x;
                System.out.println("sum:"+sum);
            }
            System.out.println();
            if (sum >= max){
                max = sum;
                result = i;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] exit = {2, 0, -1, 2};
        System.out.println(maxWeightCell(exit));
    }
}
