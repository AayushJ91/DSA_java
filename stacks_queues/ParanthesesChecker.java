//Problem: check the parenthesis and return ture if it is valid
//link: https://leetcode.com/problems/valid-parentheses/
//Source: Leetcode (20)
//Topics: Stack
//Diff: Easy

import java.util.Stack;

public class ParanthesesChecker {
    public static boolean naive(String s) {
        //Time: 4ms worst, beats 11.83;
        //Space: 41.6 MB, beats 81
        int n = s.length();
        Stack<Character> stack = new Stack<>();
        stack.push('n');
        for (int i = 0; i < n; i++) {
            char curr = s.charAt(i);
            System.out.println("curr:" + curr);
            System.out.println("peek before ifs:" + stack.peek());
            if (stack.peek() == '(' && curr == ')') {
                stack.pop();
            } else if (stack.peek() == '[' && curr == ']') {
                stack.pop();
            } else if (stack.peek() == '{' && curr == '}') {
                stack.pop();
            } else {
                stack.push(s.charAt(i));
            }
            System.out.println("peek after ifs:" + stack.peek());
            System.out.println();
        }
        if (stack.peek() == 'n') {
            return true;
        }
        return false;
    }

    static boolean optimised(String s) {
        //Time: 2ms, beats 96.84;
        //Space: 42.19 MB, beats 12.02;
        int l = s.length();
        Stack<Character> stack = new Stack<>();
        stack.add('n');
        for (int i = 0; i < l; i++) {
            char curr = s.charAt(i);
            if (curr == ')') {
                if (stack.peek() == '(') {
                    stack.pop();
                } else if (stack.peek() == 'n') {
                    stack.push(curr);
                } else {
                    return false;
                }
            } else if (curr == '}') {
                if (stack.peek() == '{') {
                    stack.pop();
                } else if (stack.peek() == 'n') {
                    stack.push(curr);
                } else {
                    return false;
                }
            } else if (curr == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                } else if (stack.peek() == 'n') {
                    stack.push(curr);
                } else {
                    return false;
                }
            }else {
                stack.push(curr);
            }
        }if (stack.peek() != 'n') {
            return false;
        }
        return true;
    }
    public static void main (String[]args){
        System.out.println(optimised("("));
    }
}
