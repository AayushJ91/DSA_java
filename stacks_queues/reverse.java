//Problem: design a stack which gives min element in it in constant time;
//link: https://www.geeksforgeeks.org/problems/reverse-a-string-using-stack/1
//Source: GFG
//Topics: Stack
//Diff: Med

import java.util.Stack;

public class reverse {
    static String rev(String s) {
        Stack<Character> st = new Stack<>();
        char[] ch = s.toCharArray();
        int l = s.length();
        for (int i = 0; i < l; i++){
            st.push(ch[i]);
        }
        for (int i = 0; i < l; i++) {
            ch[i] = st.pop();
        }
        return new String(ch);
    }

    public static void main(String[] args) {
        System.out.println(rev("piyush"));
    }
}
