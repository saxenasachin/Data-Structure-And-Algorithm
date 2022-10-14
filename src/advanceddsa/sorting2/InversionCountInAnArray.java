package advanceddsa.sorting2;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array of integers A. If i < j and A[i] > A[j], then the pair (i, j) is called an inversion of A. Find the total number of inversions of A modulo (109 + 7).
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * <p>
 * 1 <= A[i] <= 10^9
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * Output Format
 * Return the number of inversions of A modulo (109 + 7).
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [3, 2, 1]
 * Input 2:
 * <p>
 * A = [1, 2, 3]
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 0
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All pairs are inversions.
 * Explanation 2:
 * <p>
 * No inversions.
 */
public class InversionCountInAnArray {

    /**
     * Brute force method
     * Check all pairs (i, j) such that A[i] > A[j] and i < j
     */
    private static int inversionCount(ArrayList<Integer> A) {
        int count = 0;
        for (int i = 0; i < A.size() - 1; i++) {
            for (int j = i + 1; j < A.size(); j++) {
                if (A.get(i) > A.get(j)) {
                    count++;
                }
            }
        }
        return count;
    }

//    private static int optimizedInversionCount(ArrayList<Integer> A) {
//
//    }
    public static void main(String[] args) {
        int[] A = {3, 2, 1};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(inversionCount(input));
    }
}
