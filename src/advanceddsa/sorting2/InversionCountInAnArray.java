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

    /** Brute force method
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

    /**
     * Uses merge sort technique to optimize this code.
     * @param A - input list
     * @return - count of inversion count in array
     */
    private static int optimizedInversionCount(ArrayList<Integer> A) {
        return mergeSort(A, 0, A.size() - 1);
    }

    private static int mergeSort(ArrayList<Integer> A, int start, int end) {
        int mod = 1000000007;
        if (start >= end) return 0; // base case
        int mid = (start + end) / 2;
        int count1 = mergeSort(A, start, mid) % mod; // count from left subarray
        int count2 = mergeSort(A, mid + 1, end) % mod; // count from right subarray
        return (count1 + count2 + mergeAndGetCount(A, start, end, mid)) % mod;
    }

    private static int mergeAndGetCount(ArrayList<Integer> A, int start, int end, int mid) {
        int mod = 1000000007;
        int l = start;
        int r = mid + 1;
        int k = 0;
        int[] copy = new int[end - start + 1];
        int count = 0;
        while (l <= mid && r <= end) {
            if (A.get(l) <= A.get(r)) {
                copy[k++] = A.get(l++);
            } else {
                copy[k++] = A.get(r++);
                count += mid - l + 1;
            }

            count %= mod;
        }
        while (l <= mid) {
            copy[k++] = A.get(l++);
        }
        while (r <= end) {
            copy[k++] = A.get(r++);
        }
        for (int i : copy) {
            A.set(start++, i);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {6, 12, 10, 17, 10, 22, 9, 19, 21, 31, 26, 8};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(optimizedInversionCount(input));
    }
}
