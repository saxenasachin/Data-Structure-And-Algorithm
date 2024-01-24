package advanceddsa.dynamicprogramming;

/**
 * Given an array arr of non-negative integers and an integer sum, the task is to count all subsets of the given array with a sum equal to a given sum.
 * <p>
 * Note: Answer can be very large, so, output answer modulo 109+7.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * N = 6
 * arr = [5, 2, 3, 10, 6, 8]
 * sum = 10
 * Output:
 * 3
 * Explanation:
 * {5, 2, 3}, {2, 8}, {10} are possible subsets.
 * Example 2:
 * Input:
 * N = 5
 * arr = [2, 5, 1, 4, 3]
 * sum = 10
 * Output:
 * 3
 * Explanation:
 * {2, 1, 4, 3}, {5, 1, 4}, {2, 5, 3} are possible subsets.
 * Your Task:
 * You don't need to read input or print anything. Complete the function perfectSum() which takes N, array arr and sum as input parameters and returns an integer value.
 * <p>
 * Expected Time Complexity: O(N*sum)
 * Expected Auxiliary Space: O(N*sum)
 * <p>
 * Constraints:
 * 1 ≤ N*sum ≤ 106
 * 0 ≤ arr[i] ≤ 106
 */
public class CountOfSubsetSum {

    public static int perfectSum(int[] arr, int n, int sum) {
        int m = 1000000007;
        int[][] dp = new int[n + 1][sum + 1];

        // initialise array
        dp[0][0] = 1;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = (dp[i - 1][j] + dp[i - 1][j - arr[i - 1]]) % m;
                } else {
                    dp[i][j] = (dp[i - 1][j]) % m;
                }
            }
        }

        return dp[n][sum] % m;
    }

    public static void main(String[] args) {
        int N = 10;
        int[] arr = {9, 7, 0, 3, 9, 8, 6, 5, 7, 6};
        int sum = 31;

        System.out.println("perfect sum : count is : " + perfectSum(arr, N, sum));
    }
}
