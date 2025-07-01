//Problem: design a stack which gives min element in it in constant time;
//link: https://leetcode.com/problems/min-stack/
//Source: Leetcode (155)
//Topics: Stack
//Diff: Med

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class minStack {
    //Nhi hua
    //runtime error
    private int top;
    private ArrayList<Integer> list;
    private int min1;
    private int min2;
    public minStack() {
        top = -1;
        list = new ArrayList<>();
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
    }

    public void push(int val) {
        top++;
        list.add(val);
        if (val <= min1) {
            min2 = min1;
            min1 = val;
        }
        System.out.println("min1 pos:"+(min1));
        System.out.println("min2 pos:"+(min2));
        System.out.println();
    }

    public void pop() {
        if (list.getLast() == min1) {
            min1 = min2;
        }
        list.removeLast();
        top--;
    }

    public int top() {
//        return arr[top];
        return 5;
    }

    public int getMin() {
        return min1;
    }

    public static void main(String[] args) {
        minStack n = new minStack();
        n.push(2);
        n.push(0);
        n.push(3);
        n.push(0);
        System.out.println(n.getMin());
        n.pop();
        System.out.println(n.getMin());
        n.pop();
        System.out.println(n.getMin());
        n.pop();
        System.out.println(n.getMin());
//        int[] arr = new int[1];
//        System.out.println(Arrays.toString(arr));
    }
}
