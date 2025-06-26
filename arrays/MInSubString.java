//Problem: finding the shortest substring in s where all chars of t are included
//link: https://leetcode.com/problems/minimum-window-substring/
//Source: LeetCode (76)
//Topics:
//Diff: Hard


import java.util.ArrayList;
import java.util.HashMap;

public class MInSubString {
    public static String naive(String s, String t) {
        //Time: worst
        //Space: worst
        int n = s.length(), k = t.length();
        StringBuilder window = new StringBuilder();
        String res = "";
        HashMap<Character, Integer> chars = new HashMap<>();
        int len = Integer.MAX_VALUE;
        if (k > n) {
            return "";
        }
        //jo substring chalu hoga woh t ke kisi char se chaalu hoga
        for (int i = 0; i < k; i++) {
            if (chars.containsKey(t.charAt(i))) {
                chars.put(t.charAt(i), chars.get(t.charAt(i)) + 1);
            }else {
                chars.put(t.charAt(i), 1);
            }
        }
        HashMap<Character, Integer> chars1 = (HashMap<Character, Integer>) chars.clone();
        System.out.println(chars);
        int start = 0,  end = 0;
        char pres = 'a';
        for (int i = 0; i < n; i++) {
            System.out.println("i:" + i);
            System.out.println(s.charAt(i));
            HashMap<Character, Integer> map = (HashMap<Character, Integer>) chars.clone();
            if (chars1.containsKey(s.charAt(i))) {
                start = i;

                System.out.println("str:"+start);
                for (int j = start; j < n; j++) {
                    pres = s.charAt(j);
                    System.out.println("pres: "+pres);
                    if (map.containsKey(pres)) {
                        if (map.get(pres) == 1) {
                            map.remove(pres);
                        } else {
                            System.out.println(map.get(pres));
                            map.replace(pres, map.get(pres) - 1);
                        }
                    }
                    window.append(pres);
                    System.out.println(map);
                    System.out.println("win: "+window);
                    if (map.isEmpty()) {
                        System.out.println(33);
                        if (window.length() < len) {
                            len = window.length();
                            res = window.toString();
                        }
                        window.setLength(0);
                        System.out.println(res);
                        break;
                    }
                    System.out.println();
                }
                System.out.println();
                System.out.println();
            }
        }
        return res;
    }

    static String optimistic(String s, String t) {
        return "";
    }
    public static void main(String[] args) {
        System.out.println(naive("aaflslflsldkalskaaa", "aaa"));
    }
}