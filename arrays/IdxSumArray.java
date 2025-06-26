//Problem: finding the starting and end of subarray having specified sum
//link: https://www.geeksforgeeks.org/problems/subarray-with-given-sum--145933/1?page=1&category=sliding-window&sortBy=difficulty
//Source: GFG
//Topics: Sliding Window
//Diff: Med
//Time: naive se hua
//space:

import java.util.ArrayList;

public class IdxSumArray {
    static ArrayList<Integer> naive(int[] arr, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int fro = 0, nxt = 0;
        int preSum = 0;
        while (fro < n && nxt < n) {
            preSum += arr[nxt];
            if (preSum == sum) {
                res.add(fro + 1);
                res.add(nxt + 1);
                return res;
            }
            nxt++;
            if (nxt >= n) {
                fro++;
                nxt = fro;
                preSum = 0;
            }
        }
        return res;
    }

    static ArrayList<Integer> optimised(int[] arr, int sum) {
        ArrayList<Integer> res = new ArrayList<>();
        int n = arr.length;
        int last = 0;
        int start = 0;
        int currsum = 0;

        // Iterate over the array
        for (int i = 0; i < n; i++) {
            // Store sum up to current element
            currsum += arr[i];

            // Check if current sum is greater than or equal to given number
            if (currsum >= sum) {
                last = i;

                // Start from starting index till current index
                while (sum < currsum && start < last) {
                    // Subtract the element from left
                    currsum -= arr[start];
                    ++start;
                }

                // If current sum becomes equal to given number
                if (currsum == sum) {
                    res.add(start + 1);
                    res.add(last + 1);
                    break;
                }
            }
        }

        // Return the result
        return res;
    }

    public static void main(String[] args) {
        int[] num = {2,4,4,7,5};
        System.out.println(optimised(num, 5));
    }
}
