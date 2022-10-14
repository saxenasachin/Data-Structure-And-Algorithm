package advanceddsa.hashing1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 * Given an unsorted integer array A of size N.
 * <p>
 * Find the length of the longest set of consecutive elements from array A.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * <p>
 * -106 <= A[i] <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A of size N.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the length of the longest set of consecutive elements from the array A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [100, 4, 200, 1, 3, 2]
 * Input 2:
 * <p>
 * A = [2, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The set of consecutive elements will be [1, 2, 3, 4].
 * Explanation 2:
 * <p>
 * The set of consecutive elements will be [1, 2].
 */
public class LongestConsecutiveSequence {
    /**
     * Store all the numbers in set, iterate over array and check if previous number (number - 1) exits or not.
     * if previous number exist i.e. sequence will start from previous number that's why we ignore this.
     * if previous number does not exist i.e. sequece will start from this number, iterate from this number to max number
     * of array to find of consecutive numbers.
     *
     * @param A - input array
     * @return - count of the longest consecutive numbers
     */
    private static int countLongestSequence(ArrayList<Integer> A) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int maxCount = Integer.MIN_VALUE;
        // store all the numbers in set and find max of the array
        for (Integer integer : A) {
            max = Math.max(integer, max);
            set.add(integer);
        }
        // iterate over array and check if previous number exist or not
        for (Integer integer : A) {
            if (!set.contains(integer - 1)) {
                // sequence will start here
                int count = 1;
                while (set.contains(++integer)) count++;
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }

    public static void main(String[] args) {
        int[] A = {100, 4, 200, 1, 3, 2};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(countLongestSequence(input));
    }
}
