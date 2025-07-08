//Problem: median of the given array;
//link: https://leetcode.com/problems/find-median-from-data-stream/
//Source: LeetCode (295)
//Topics: Heaps
//Diff: hard

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {
    //Time Limit Exceeded
    PriorityQueue<Integer> nums;
    double med;
    public MedianFinder() {
        nums = new PriorityQueue<>();
        med = -0.5;
    }

    public void addNum(int num) {
        nums.add(num);
        med += 0.5;
        System.out.println(nums);
    }

    public double findMedian() {
        PriorityQueue<Integer> clo = new PriorityQueue<>(nums);
        double v = med;
        if (nums.size() % 2 == 0) {
            v += 0.5;
            int pre = 0;
            while (v != 0){
                pre = clo.poll();
                v--;
            }
            int post = clo.poll();
            return (double) (pre + post) / 2;
        }while (v != 0){
            clo.poll();
            v--;
        }
        return clo.poll();
    }

    public static void main(String[] args) {
        MedianFinder med = new MedianFinder();
        med.addNum(1);med.addNum(2);
        System.out.println(med.findMedian());
        med.addNum(3);
        System.out.println(med.findMedian());
    }
}
