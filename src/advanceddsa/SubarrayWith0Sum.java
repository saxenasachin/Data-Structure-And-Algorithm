package advanceddsa;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 *
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 *
 * Problem Constraints
 * 1 <= |A| <= 100000
 *
 * -10^9 <= A[i] <= 10^9
 *
 * Input Format
 * The only argument given is the integer array A.
 *
 * Output Format
 * Return whether the given array contains a subarray with a sum equal to 0.
 *
 *
 *
 * Example Input
 * Input 1:
 *
 *  A = [1, 2, 3, 4, 5]
 * Input 2:
 *
 *  A = [-1, 1]
 *
 * Example Output
 *
 * Output 1:
 *
 *  0
 * Output 2:
 *
 *  1
 *
 *
 * Example Explanation
 *
 * Explanation 1:
 *
 *  No subarray has sum 0.
 * Explanation 2:
 *
 *  The array has sum 0.
 */
public class SubarrayWith0Sum {
    /**
     * Brute force - Check for all subarray with 0 sum.
     * @return - 1/0
     */
    private static int bruteForceMethodToCheckIfZeroSumSubarrayExist(ArrayList<Integer> A) {
        int n = A.size();
        for (int i = 0; i < n; i++) {
            int sum = A.get(i);
            if (sum == 0) return 1;
            for (int j = i + 1; j < n; j++) {
                sum += A.get(j);
                if (sum == 0) return 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(bruteForceMethodToCheckIfZeroSumSubarrayExist(input));
    }
}
