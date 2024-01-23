package advanceddsa.dynamicprogramming;

/**
 * You are given weights and values of N items,
 * put these items in a knapsack of capacity W
 * to get the maximum total value in the knapsack.
 * Note that we have only one quantity of each item.
 * In other words, given two integer arrays val[0..N-1]
 * and wt[0..N-1] which represent values and weights
 * associated with N items respectively.
 * Also given an integer W which represents knapsack capacity,
 * find out the maximum value subset of val[] such that
 * sum of the weights of this subset is smaller than or equal to W.
 * You cannot break an item, either pick the complete item or don't pick it (0-1 property).
 */
public class Knapsack {

    private static final int[][] t = new int[1002][1002];

    static {
        // initialise matrix with -1;
        for (int i = 0; i < t.length; i++) {
            for (int j = 0; j < t[0].length; j++) {
                t[i][j] = -1;
            }
        }
    }

    /**
     * This method using recursion + memoization, if existing profit found for a given indices,
     * simply return, otherwise calculate using recursive fun and stores it in the matrix.
     *
     * @param w   - weight of the knapsack
     * @param wt  - weight array
     * @param val - profit array
     * @param n   - size of the array
     * @return - max profit
     */
    static int knapSack(int w, int[] wt, int[] val, int n) {
        if (n == 0 || w == 0) {
            return 0;
        }
        if (t[n][w] != -1) {
            return t[n][w];
        }
        if (wt[n - 1] <= w) {
            return t[n][w] = Math.max(
                    val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1),
                    knapSack(w, wt, val, n - 1)
            );
        } else {
            return t[n][w] = knapSack(w, wt, val, n - 1);
        }
    }

    /**
     * This method using memoization table only, fir initialize first row and column with the value
     * same as base condition in recursive solution. here it is 0.
     * Build remaining cell of matrix by using previously filled cell.
     *
     * @param w   - weight of the knapsack
     * @param wt  - weight array
     * @param val - profit array
     * @param n   - size of the array
     * @return - max profit
     */
    static int knapSackWithTopDown(int w, int[] wt, int[] val, int n) {
        int[][] dp = new int[n + 1][w + 1];

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                }
            }
        }

        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j < dp[0].length; j++) {
                if (wt[i - 1] <= j) {
                    // There are two case in this scenario, either item is included or not included.
                    // if item is included, Then find maximum between - (included scenario and not included scenario)
                    // if included ->
                    // then
                    //          current item's profit (val[i - 1]) +
                    //          profit till previous items i.e. till previous row (i - 1) in dp matrix
                    //          for the weight i.e. column is [current bag size (j) - weight of currently included item] (j - wt[i - 1])
                    //          values and weights array are 0 index based, that is why current item / weight means is (i - 1) or (j - 1).
                    // if not included ->
                    // then
                    //          we need to find max profit for previous items i.e. till previous row (i - 1)
                    //          for the current bag size (j)
                    dp[i][j] = Math.max(
                            val[i - 1] + dp[i - 1][j - wt[i - 1]],
                            dp[i - 1][j] // if not included, then max profit till previous item (i) and current weight (j)
                    );
                } else {
                    // here only one scenario, we can't include this item as weight is greater than bag size.
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[n][w];
    }

    public static void main(String[] args) {
//        input 1
//        int n = 88;
//        int w = 71;
//        int[] values = {81, 28, 91, 49, 65, 97, 19, 75, 21, 88, 47, 10, 26, 67, 9, 39, 27, 85, 72, 64, 24, 14, 87, 7, 94, 100, 53, 1, 83, 71, 11, 87, 67, 39, 73, 49, 51, 44, 36, 60, 57, 97, 47, 2, 100, 77, 77, 35, 30, 42, 23, 18, 43, 10, 23, 52, 11, 80, 44, 8, 27, 90, 90, 93, 40, 96, 28, 60, 69, 34, 40, 13, 54, 74, 7, 82, 81, 20, 82, 5, 43, 69, 24, 55, 26, 49, 53, 98};
//        int[] weights = {30, 12, 58, 32, 38, 59, 6, 4, 5, 8, 53, 17, 4, 75, 23, 41, 5, 39, 31, 60, 100, 60, 92, 12, 37, 82, 15, 47, 78, 74, 6, 86, 86, 35, 65, 69, 87, 89, 12, 97, 28, 33, 100, 33, 46, 47, 17, 80, 60, 23, 10, 49, 1, 62, 7, 77, 9, 49, 52, 41, 82, 95, 83, 79, 16, 11, 16, 54, 22, 96, 90, 3, 7, 80, 1, 56, 37, 23, 85, 59, 38, 45, 26, 76, 4, 52, 98, 75};

//        input 2
        int n = 3;
        int w = 4;
        int[] values = {1, 2, 3};
        int[] weights = {4, 5, 1};

        System.out.println("max profit is : " + knapSackWithTopDown(w, weights, values, n));
    }
}
