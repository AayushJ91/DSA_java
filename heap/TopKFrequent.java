//Problem: return an array of top k frequent elements in the given array;
//link: https://leetcode.com/problems/top-k-frequent-elements/
//Source: LeetCode (347)
//Topics: Heaps
//Diff: Med

import java.util.*;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] result = new int[k];
        for (int i = 0; i < nums.length; i++) {
            if (freq.containsKey(nums[i])){
                freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
            }else {
                freq.put(nums[i], 1);
            }
        }
        System.out.println(freq);

        pq.addAll(freq.values());
        System.out.println(pq);
        int i = 0;
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            System.out.println("top:"+pq.peek());
            System.out.println("freq:"+entry.getValue());
            System.out.println("ele:"+entry.getKey());
            System.out.println("k:"+k);
                if (k == 0){
                    break;
                }
                if (Objects.equals(entry.getValue(), pq.peek())){
                    pq.poll();
                    result[i] = entry.getKey();
                    i++;k--;
                }
            System.out.println("result:"+Arrays.toString(result));
            System.out.println();
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,7,7,8,2,3,1,1,1,10,11,5,6,2,4,7,8,5,6};
        System.out.println(Arrays.toString(topKFrequent(nums, 10)));
    }
}
