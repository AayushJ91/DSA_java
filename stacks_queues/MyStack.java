//Problem: Implement stack. Ceate methods for push() and pop()
//link: https://www.geeksforgeeks.org/problems/implement-stack-using-array/1
//Source: GFG
//Topics: Stack
//Diff: Easy

import java.util.ArrayList;
import java.util.Arrays;

public class MyStack {
    private int[] arr;
    private int top;

    public MyStack() {
        arr = new int[1000];
        top = -1;
    }

    public void push(int x) {
        arr[top + 1] = x;
        top++;
    }

    public int pop() {
        if (top == -1) {
            return -1;
        }
        int temp = arr[top];
        arr[top] = 0;
        top--;
        return temp;
    }
    public int peek() {
        return arr[top];
    }

    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(5);
        stack.push(4);
        stack.push(3);

        System.out.println(Arrays.toString(stack.arr));
        System.out.println(stack.pop());
        System.out.println(Arrays.toString(stack.arr));
        System.out.println(stack.top);
    }
}
