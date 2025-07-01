//Problem: Insert the element at the bottom of the stack;
//link: https://www.geeksforgeeks.org/problems/next-larger-element-1587115620/1
//Source: GFG
//Topics: Stack
//Diff: Easy

import javax.naming.InsufficientResourcesException;
import java.util.ArrayList;
import java.util.Stack;

public class InsertAtBottom {
    public static Stack<Integer> naive(Stack<Integer> st, int x) {
        int n = st.toArray().length;
        ArrayList<Integer> list = new ArrayList<>();
        while (!st.empty()) {
            list.add(st.pop());
        }
        System.out.println(list);
        st.push(x);
        for (int i = 0; i < n; i++) {
            st.push(list.get(n-i-1));
        }
        return st;
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(2);
        st.push(6);
        st.push(8);
        System.out.println(st.peek());
        System.out.println(naive(st, 5).toString());
    }
}
