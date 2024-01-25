package advanceddsa.dynamicprogramming;

/**
 * Problem Description
 * Given a positive integer A, write a program to find the Ath Fibonacci number.
 * <p>
 * In a Fibonacci series, each term is the sum of the previous two terms and the first two terms of the series are 0 and 1. i.e. f(0) = 0 and f(1) = 1. Hence, f(2) = 1, f(3) = 2, f(4) = 3 and so on.
 * <p>
 * NOTE: 0th term is 0. 1th term is 1 and so on.
 * <p>
 *
 *
 * Problem Constraints
 * 0 <= A <= 44
 * <p>
 *
 *
 * Input Format
 * First and only argument is an integer A.
 * <p>
 *
 *
 * Output Format
 * Returns an integer denoting the Ath Fibonacci number.
 * <p>
 *
 *
 * Example Input
 *  1:
 * <p>
 *  A = 4
 * Input 2:
 * <p>
 *  A = 6
 * <p>
 *
 * Example Output
 *  1:
 * <p>
 *  3
 * Output 2:
 * <p>
 *  8
 * <p>
 *
 * Example Explanation
 *  1:
 * <p>
 *  Terms of Fibonacci series are: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
 *  0th term is 0 So, 4th term of Fibonacci series is 3.
 * Explanation 2:
 * <p>
 *  6th term of Fibonacci series is 8.
 */
public class FibonacciNumber {

    public static void main(String[] args) {
        int A = 4;
        System.out.println("Fibonacci Number : " + findFibonacci(A));
    }

    private static int findFibonacci(int A) {

        if (A == 0) return 0;
        if (A == 1) return 1;
        if (A == 2) return 1;

        int[] dp = new int[A + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= A; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[A];
    }
}
