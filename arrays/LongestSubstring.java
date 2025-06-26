//Problem: lenght of longest substring without duplicate
//link: https://leetcode.com/problems/longest-substring-without-repeating-characters/
//Source: LeetCode (3)
//Topics: Sliding Window
//Diff: Med
//Time:
//space:

import java.util.*;

public class LongestSubstring {
    static int naive(String s) {
        int n = s.length();
        int res = 0, len = 0;
        int start = 0, last = 0;
        ArrayList<Character> ch = new ArrayList<>();
        while (start<=n && last < n){
            if (ch.contains(s.charAt(last))) {
                start++;
                last = start;
                ch.clear();
                len = 0;
            }else {
                ch.add(s.charAt(last));
                last++;
                len++;
            }
            System.out.println(ch);
            System.out.println(len);
            res = Math.max(res, len);
            System.out.println(res);
            System.out.println();
        }
        return res;
    }
    static int optimistic(String s) {
        int n = s.length();
        int res = 0, len = 0;
        int start = 0, last = 0;
        HashSet<Character> ch = new HashSet<>();
        while (start <= last && last < n){
            if (ch.contains(s.charAt(last))) {
                ch.remove(s.charAt(start));
                start++;
                len--;
            }else {
                ch.add(s.charAt(last));
                len++;
                last++;
            }
            // in this many comparisions are taking place, like in while statement, then in res. Also it has an extra
            // storage of variable len which can be replaced.
            res = Math.max(res, len);
            System.out.println(ch);
            System.out.println();
        }
        return res;
    }
    static int optimistic2(String s) {
        Set<Character> stringSet = new HashSet<>();
        int r = 0, l = 0;
        int maxLength = 0;

        while(r < s.length()) {
            while(stringSet.contains(s.charAt(r))) {
                stringSet.remove(s.charAt(l));
                l++;
            }
            //will not add the duplicate char
            stringSet.add(s.charAt(r));
            maxLength = Math.max(maxLength, r - l + 1);
            r++;
        }
        return maxLength;

    }
    public static void main(String[] args) {
        System.out.println(optimistic2("abcabc"));
    }
}
