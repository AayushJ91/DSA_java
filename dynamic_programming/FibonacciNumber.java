import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FibonacciNumber {
    //F1 = F2 = 1; F0 = 0; Fn = F(n-1) + F(n-2)
    static int naive(int n) {
        //Has the exponential time complexity
        if (n <= 1) {
            return n;
        }
        return naive(n-1) + naive(n-2);
    }

    static int memoization(int n, int[] dp) {
        //this has linear time complexity because we are fetching the values from the values from the memo

        //here we are creating a list 'memo' and will check whether nth index is in it?
        //if nth index is there then we will return that value from memo
        //if not then will add that number to the memo
        if (n <= 1) return n;

        // If already computed
        if (dp[n] != -1) return dp[n];
        //the memo - dp is already empty filled with -1

        // Compute and store in dp
        dp[n] = memoization(n - 1, dp) + memoization(n - 2, dp);
        return dp[n];
    }

    static int tabulation(int n) {
        if (n <= 1) {
            return n;
        }
        int[] fib = new int[n+1];
        fib[0] = 0;
        fib[1] = 1;
        int f = 0;
        for (int i = 2; i <= n; i++) {
            f = fib[i - 1] + fib[i - 2];
            fib[i] = f;
        }
        return fib[n];
    }

    public static void main(String[] args) {
        int[] dp = new int[12];
        Arrays.fill(dp, -1);
        System.out.println(tabulation(5));
        System.out.println(memoization(5,dp));
        System.out.println(naive(5));
    }
}
