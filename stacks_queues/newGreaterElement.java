//Problem: given an arr[] of int. Find the nearest greater number in the array on its right side.
//link: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
//Source: GFG
//Topics: Stack
//Diff: Med -- nhi hua

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.Queue;

public class newGreaterElement {
    public static ArrayList<Integer> naive(int[] arr) {
        //Time Limit Exceeded
        int l = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = 0; i < l; i++) {
            int curr = arr[i];
            int j = i+1;
            if (i == l-1){
                res.add(-1);
            }
            while (j < l) {
                if (arr[j] > curr) {
                    res.add(arr[j]);
                    break;
                }if (j == l-1) {
                    res.add(-1);
                }
                j++;
            }
        }
        return res;
    }

    public static ArrayList<Integer> optimistic(int[] arr) {
        //nahi hua
        int l = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Queue<Integer> qu = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            qu.add(arr[i]);
        }
        System.out.println(qu.peek());
        int j = 0;
        while (j < l) {
            Queue<Integer> q2 = new LinkedList<>(qu);
            int curr = q2.remove();
            if (q2.peek() > curr) {
                res.add(q2.remove());
            }else {
                q2.remove();
            }
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 50};
        System.out.println(optimistic(arr));
    }
}
