package advanceddsa.dynamicprogramming;

/**
 * Problem Description
 * Given a 2 x N grid of integers, A, your task is to choose numbers from the grid such that sum of these numbers is maximized.
 * However, you cannot choose two numbers that are adjacent horizontally, vertically, or diagonally.
 * <p>
 * Return the maximum possible sum.
 * <p>
 * Note: You are allowed to choose more than 2 numbers from the grid.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 20000
 * 1 <= A[i] <= 2000
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains a 2d matrix, A.
 * <p>
 * <p>
 * Output Format
 * Returns an integer, representing the maximum possible sum.
 * <p>
 * <p>
 * Example Input
 * 1:
 * <p>
 * A = [
 * [1]
 * [2]
 * ]
 * Input 2:
 * <p>
 * A = [
 * [1, 2, 3, 4]
 * [2, 3, 4, 5]
 * ]
 * <p>
 * <p>
 * Example Output
 * 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 8
 * <p>
 * <p>
 * Example Explanation
 * 1:
 * <p>
 * We will choose 2 (From second row to first column).
 * Explanation 2:
 * <p>
 * We will choose three (From second row to second column) and five (From second row to fourth column).
 */
public class MaxSumWithoutAdjacentElements {
    public static int adjacent(int[][] A) {
        // merge two rows into one row, by taking maximum between two values
        int[] maxInColumn = new int[A[0].length];
        for (int i = 0; i < A[0].length; i++) {
            maxInColumn[i] = Math.max(A[0][i], A[1][i]);
        }

        // return if array length is <= 2
        if (maxInColumn.length == 1) return maxInColumn[0];
        if (maxInColumn.length == 2) return Math.max(maxInColumn[0], maxInColumn[1]);

        maxInColumn[1] = Math.max(maxInColumn[0], maxInColumn[1]);

        // build the remaining item in the maxInColumn array,
        // for a position, if we include, then the max sum will be this value + maxSum till (position - 2)
        // if we don't include, then the max sum will be maxSum(position - 1).
        for (int i = 2; i < maxInColumn.length; i++) {
            maxInColumn[i] = Math.max(maxInColumn[i] + maxInColumn[i - 2], maxInColumn[i - 1]);
        }

        return maxInColumn[maxInColumn.length - 1];
    }

    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3, 4},
                {2, 3, 4, 5}
        };

        System.out.println("maximum sum without adjacent elements : " + adjacent(A));
    }
}
