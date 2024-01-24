package advanceddsa.dynamicprogramming;

/**
 * Problem Description
 * Given an integer A. Return minimum count of numbers, sum of whose squares is equal to A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Returns an integer denoting the minimum count.
 * <p>
 * <p>
 * <p>
 * Example
 * Input 1:
 * <p>
 * A = 6
 * Input 2:
 * <p>
 * A = 5
 * <p>
 * <p>
 * Example
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example
 * Explanation 1:
 * <p>
 * Possible combinations are: (12 + 12 + 12 + 12 + 12 + 12) and (12 + 12 + 22).
 * Minimum count of numbers, sum of whose squares is 6 is 3.
 * Explanation 2:
 * <p>
 * We can represent 5 using only 2 numbers i.e., 12 + 22 = 5
 */
public class MinimumNumberOfSquares {

    public static int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        for (int i = 1; i <= A; i++) {
            // base condition, for each number i, take min count is the same as i.
            // for ex: for i = 4, we can take squares of 1 four times.
            dp[i] = i;

            // fill all the other cells in dp array,
            // iterate till square root of i, because the maximum number which we can include in our output is
            // square root of given i.
            // for each cell, consider subtracting each square of x and find the minimum count of numbers
            //  for the remaining number (i - (x * x)).
            // for ex: for A = 12, we can take (square of 1 = 1), (square of 2 = 4), (square of 3 = 9)
            // subtract these from A, then other sub problems will be (A - 1 = 11), (A - 4 = 8), (A - 9 = 3) and so on.
            // again, solve the subproblems.
            for (int x = 1; x * x <= i; x++) {
                dp[i] = Math.min(dp[i], 1 + dp[i - x * x]);
            }
        }
        return dp[A];
    }

    public static void main(String[] args) {
        int A = 6;
        System.out.println("minimum count of numbers, sum of whose squares is equal to A : " + countMinSquares(A));
    }
}
