//Problem: Implement 2 stack. Ceate methods for push() and pop()
//link: https://www.geeksforgeeks.org/problems/implement-two-stacks-in-an-array/1
//Source: GFG
//Topics: Stack
//Diff: Easy

public class TwoStacks {
    int[] arr;
    int top1;
    int top2;
    TwoStacks() {
        arr = new int[1000];
        top1 = top2 = -1;
    }

    // Function to push an integer into the stack1.
    void push1(int x) {
        // code here
        top1++;
        arr[top1] = x;
    }

    // Function to push an integer into the stack2.
    void push2(int x) {
        top2++;
        arr[top2] = x;
        // code here
    }

    // Function to remove an element from top of the stack1.

    int pop1() {
        // code here
        if (top1 == -1){
            return -1;
        }
        int temp = arr[top1];
        arr[top1] = 0;
        top1--;
        return temp;
    }


    // Function to remove an element from top of the stack2.
    int pop2() {
        // code here
        if (top2 == -1){
            return -1;
        }
        int temp = arr[top2];
        arr[top2] = 0;
        top2--;
        return temp;
    }
}
