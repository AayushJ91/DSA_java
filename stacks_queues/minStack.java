//Problem: design a stack which gives min element in it in constant time;
//link: https://leetcode.com/problems/min-stack/
//Source: Leetcode (155)
//Topics: Stack
//Diff: Med

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;
import java.util.PriorityQueue;

public class minStack {
    //Nhi hua
    //runtime error
    private int top;
    private final ArrayList<Integer> list;
    PriorityQueue<Integer> heap;
    public minStack() {
        top = -1;
        list = new ArrayList<>();
        heap = new PriorityQueue<>();
    }

    public void push(int val) {
        top++;
        list.add(val);
        heap.add(val);
    }

    public void pop() {
        if (Objects.equals(list.getLast(), heap.peek())){
            heap.poll();
        }
        list.removeLast();
        top--;
    }

    public int top() {
        return list.get(top);
    }

    public int getMin() {
        if (heap.isEmpty()){
            return 0;
        }
        return heap.peek();
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
