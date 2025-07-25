//Problem: compare the given strings where # means backspace
//link: https://leetcode.com/problems/backspace-string-compare/
//Source: LeetCode (844)
//Topics: Two Pointers
//Diff: Easy

import java.util.ArrayList;
import java.util.List;

public class BacksapceCompare {
    //1ms, beats 78.8;
    //41.65, 67.75;
    public static boolean backspaceCompare(String s, String t) {
        List<Character> slist = help(s);
        System.out.println("slist:"+slist);
        List<Character> tlist = help(t);
        System.out.println("tlist:"+tlist);
        if (slist.size() != tlist.size()) {
            return false;
        }
        for (int i = 0; i < slist.size(); i++) {
            if (slist.get(i) != tlist.get(i)) {
                return false;
            }
        }
        return true;
    }

    static List<Character> help(String s) {
        List<Character> res = new ArrayList<>();
        char behind = s.charAt(0);
        char ahead = s.charAt(0);
        System.out.println(s);
        int i = 0, len = s.length();
        while (i < len) {
            ahead = s.charAt(i);
            System.out.println(ahead);
            if (ahead == '#') {
                if (!res.isEmpty()) {
                    res.removeLast();
                }
            }else{
                res.add(ahead);
            }
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(backspaceCompare("#ahsdfasdha######c", "a##c"));
    }
}
