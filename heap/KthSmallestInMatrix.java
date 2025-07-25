//Problem: return the kth smallest value from the matrix where rows and columns are each arranged in ascending orde
//link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
//Source: LeetCode(378)
//Topics: heap
//Diff: Med

import java.util.PriorityQueue;

public class KthSmallestInMatrix {
    public static int kthSmallest(int[][] matrix, int k) {
        //23ms, 11.4;
        //48.17 MB, 76.26;
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int[] ints : matrix) {
            for (int j = 0; j < matrix.length; j++) {
                heap.add(ints[j]);
            }
        }
        for (int i = 0; i < k-1; i++){
            heap.poll();
        }
        return heap.poll();
    }

    public static void main(String[] args) {
        int[][] matrix = {{-5}};
        System.out.println(kthSmallest(matrix, 1));
    }
}
