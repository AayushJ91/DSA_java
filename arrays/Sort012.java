//Problem: Kth the smallest number in the array
//link: https://www.geeksforgeeks.org/problems/kth-smallest-element5635/1
//Source: LoveBabbar
//Topics: HashMap
//Diff: Easy
//Time:
//space:

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Sort012 {
    static void sort012(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);;
        }
        System.out.println(map);
        for (int i = 0; i < map.get(0); i++) {
            res.add(0);
        }
        for (int i = 0; i < map.get(1); i++) {
            res.add(1);
        }
        for (int i = 0; i < map.get(2); i++) {
            res.add(2);
        }
        arr = res.stream().mapToInt(i -> i).toArray();
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 0, 1, 2};
        sort012(arr);
    }
}
