//Problem: we have to return the adjancency list of the graph whose edges list is give
//link: https://www.geeksforgeeks.org/problems/print-adjacency-list-1587115620/1?page=1&category=Graph&sortBy=difficulty
//Source: gfg
//Topics: Graphs
//Diff: Easy

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AdjacencyList {
    public static List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> res = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            res.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int[] currArr = edges[i];
            res.get(currArr[0]).add(currArr[1]);
            res.get(currArr[1]).add(currArr[0]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] edge = {{0,1}, {0,4}, {4,1}, {4,3}, {1,3}, {1,2}, {3,2}};
        System.out.println(printGraph(5, edge));
    }
}
