package advanceddsa.stack2;

/**
 * Given a 2D binary matrix of integers A containing 0's and 1's of size N x M.
 * <p>
 * Find the largest rectangle containing only 1's and return its area.
 * <p>
 * Note: Rows are numbered from top to bottom and columns are numbered from left to right.
 * <p>
 * <p>
 * Input Format
 * <p>
 * The only argument given is the integer matrix A.
 * Output Format
 * <p>
 * Return the area of the largest rectangle containing only 1's.
 * Constraints
 * <p>
 * 1 <= N, M <= 1000
 * 0 <= A[i] <= 1
 * For Example
 * <p>
 * Input 1:
 * A = [   [0, 0, 1]
 * [0, 1, 1]
 * [1, 1, 1]   ]
 * Output 1:
 * 4
 * <p>
 * Input 2:
 * A = [   [0, 1, 0, 1]
 * [1, 0, 1, 0]    ]
 * Output 2:
 * 1
 */
public class MaximumRectangle {

    public static int solve(int[][] A) {
        int maxArea = Integer.MIN_VALUE;
        int[] row = new int[A[0].length];
        for (int[] ints : A) {
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] == 0) {
                    row[j] = 0;
                } else {
                    row[j] += ints[j];
                }
            }
            int maxRectangleInARow = LargestRectangleInHistogram.largestRectangleArea(row);
            maxArea = Math.max(maxArea, maxRectangleInARow);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[][] A = {
                {0, 1, 1},
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {1, 0, 0},
                {1, 1, 1},
                {0, 1, 0},
        };
        System.out.println(solve(A));
    }
}
