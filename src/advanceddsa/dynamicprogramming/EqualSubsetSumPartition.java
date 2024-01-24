package advanceddsa.dynamicprogramming;

/**
 * Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.
 * =
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 * Example 2:
 * <p>
 * Input: nums = [1,2,3,5]
 * Output: false
 * Explanation: The array cannot be partitioned into equal sum subsets.
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums. length <= 200
 * 1 <= nums[i] <= 100
 */
public class EqualSubsetSumPartition {

    public static boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }

        int sumToFind = sum / 2;
        int N = nums.length;
        boolean[][] dp = new boolean[N + 1][sumToFind + 1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= sumToFind; j++) {
                if (j == 0) {
                    dp[i][j] = true;
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= sumToFind; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[N][sumToFind];
    }

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println("Can be partitioned: " + canPartition(nums));
    }
}
