//Problem: implement queue using 2 stacks;
//link: https://leetcode.com/problems/implement-queue-using-stacks/
//Source: Leetcode (232)
//Topics: Stack & Queue
//Diff: Easy

import java.util.Stack;

public class MyQueue {
    //Time: 0ms best, beats 100;
    //Space: 40.8 MB appreciatable, beats 51;
    private Stack<Integer> st1;
    private Stack<Integer> st2;
    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        while (!st1.empty()) {
            st2.push(st1.pop());
        }
        int res = st2.pop();
        while (!st2.empty()) {
            st1.push(st2.pop());
        }
        return res;
    }

    public int peek() {
        while (!st1.empty()) {
            st2.push(st1.pop());
        }
        int res = st2.peek();
        while (!st2.empty()) {
            st1.push(st2.pop());
        }
        return res;
    }

    public boolean empty() {
        return st1.empty() && st2.empty();
    }

    public static void main(String[] args) {
        MyQueue q = new MyQueue();
        q.push(1);
        q.push(2);
        q.push(3);
        q.push(4);
        System.out.println(q.pop());
        q.push(5);
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
        System.out.println(q.pop());
    }
}
