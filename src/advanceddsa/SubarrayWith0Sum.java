package advanceddsa;

import java.util.*;

/**
 * Problem Description
 * Given an array of integers A, find and return whether the given array contains a non-empty subarray with a sum equal to 0.
 * <p>
 * If the given array contains a sub-array with sum zero return 1, else return 0.
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * -10^9 <= A[i] <= 10^9
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * Output Format
 * Return whether the given array contains a subarray with a sum equal to 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * Input 2:
 * <p>
 * A = [-1, 1]
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 0
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * No subarray has sum 0.
 * Explanation 2:
 * <p>
 * The array has sum 0.
 */
public class SubarrayWith0Sum {
    /**
     * Brute force - Check for all subarray with 0 sum.
     *
     * @param A - input array
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

    /**
     * We can also use hashing. The idea is to iterate through the array and for every element arr[i],
     * calculate the sum of elements from 0 to i (this can simply be done as sum += arr[i]).
     * If the current sum has been seen before, then there is a zero-sum array.
     * Hashing is used to store the sum values so that we can quickly store sum and
     * find out whether the current sum is seen before or not.
     * Example :
     * <p>
     * arr[] = {1, 4, -2, -2, 5, -4, 3}
     * <p>
     * If we consider all prefix sums, we can
     * notice that there is a subarray with 0
     * sum when :
     * 1) Either a prefix sum repeats or
     * 2) Or prefix sum becomes 0.
     * <p>
     * Prefix sums for above array are:
     * 1, 5, 3, 1, 6, 2, 5
     * <p>
     * Since prefix sum 1 repeats, we have a subarray
     * with 0 sum.
     *
     * @param A - input array
     * @return - 1/0 true - 1 false - 0
     */
    private static int checkIfZeroSumSubarrayExist(ArrayList<Integer> A) {
        int n = A.size();
        long sum = 0;
        Set<Long> prefixSumSet = new HashSet<>();
        for (Integer integer : A) {
            sum += integer;
            if (prefixSumSet.contains(sum) || sum == 0) {
                return 1;
            } else {
                prefixSumSet.add(sum);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] A = {-1, 1};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(checkIfZeroSumSubarrayExist(input));
    }
}
