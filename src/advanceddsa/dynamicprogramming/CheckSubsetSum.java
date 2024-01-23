package advanceddsa.dynamicprogramming;

/**
 * Given an array of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 * Example 1:
 * Input:
 * N = 6
 * arr[] = {3, 34, 4, 12, 5, 2}
 * sum = 9
 * Output: 1
 * Explanation: Here there exists a subset with
 * sum = 9, 4+3+2 = 9.
 * Example 2:
 * Input:
 * N = 6
 * arr[] = {3, 34, 4, 12, 5, 2}
 * sum = 30
 * Output: 0
 * Explanation: There is no subset with sum 30.
 * Your Task:
 * You don't need to read input or print anything. Your task is to complete the function isSubsetSum() which takes the array arr[], its size N and an integer sum as input parameters and returns boolean value true if there exists a subset with given sum and false otherwise.
 * The driver code itself prints 1, if returned value is true and prints 0 if returned value is false.
 * Expected Time Complexity: O(sum*N)
 * Expected Auxiliary Space: O(sum*N)
 * Constraints:
 * 1 <= N <= 100
 * 1<= arr[i] <= 100
 * 1<= sum <= 104
 */
public class CheckSubsetSum {

    static Boolean isSubsetSum(int N, int[] arr, int sum) {
        boolean[][] dp = new boolean[N + 1][sum + 1];

        // initialisation, default value of a boolean array is false
        // here I am filling only for true cell
        // first column is completely true as we can make sum = 0 by
        // not selecting any elements from the array i.e. empty subset {}.
        // and first row will be false except for (i = 0 and j = 0)
        // as we can't make any sum > 0 by not picking any elements from array.
        // as row = 0 (i = 0) represents no elements in the array.
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    // Here we have two choice, 1. include item from array to make for sum or otherwise.
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sum];
    }

    public static void main(String[] args) {
//        int N = 6;
//        int[] arr = {3, 34, 4, 12, 5, 2};
//        int sum = 9;

        int N = 6;
        int[] arr = {3, 34, 4, 12, 5, 2};
        int sum = 30;

        System.out.println("Is subset of the given sum present : " + isSubsetSum(N, arr, sum));
    }
}
