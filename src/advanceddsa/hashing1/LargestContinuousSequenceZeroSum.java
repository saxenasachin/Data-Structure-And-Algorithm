package advanceddsa.hashing1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given an array A of N integers.
 * <p>
 * Find the largest continuous sequence in a array which sums to zero.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 106
 * <p>
 * -107 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * Single argument which is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array denoting the longest continuous sequence with total sum of zero.
 * <p>
 * NOTE : If there are multiple correct answers, return the sequence which occurs first in the array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * A = [1,2,-2,4,-4]
 * <p>
 * <p>
 * Example Output
 * [2,-2,4,-4]
 * <p>
 * <p>
 * Example Explanation
 * [2,-2,4,-4] is the longest sequence with total sum of zero.
 */
public class LargestContinuousSequenceZeroSum {

    public static ArrayList<Integer> getLongestSequence(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = Integer.MIN_VALUE;
        int[] pairOfIndices = {-1, -1}; // start and end index of number in between sum is zero.
        int sum = 0;
        for (int i = 0; i < A.size(); i++) {
            sum += A.get(i);
            if (sum == 0) { // Check if sum is 0, then sequence will start from 0 till i.
                if (i > maxLength) {
                    maxLength = i + 1;
                    pairOfIndices[0] = 0;
                    pairOfIndices[1] = i;
                }
            }
            if (map.containsKey(sum)) { // if sum is found in map, calculate the length and compare with previously calculated length
                int length = i - map.get(sum);
                if (length > maxLength) { // if greater than previous length assign new value of start and end index.
                    maxLength = length;
                    pairOfIndices[0] = map.get(sum) + 1;
                    pairOfIndices[1] = i;
                }
            } else {
                map.put(sum, i);
            }
        }
        if (pairOfIndices[0] == -1) return output; // if no index found, return empty list.
        for (int i = pairOfIndices[0]; i <= pairOfIndices[1]; i++) { // return all the element from start to end index.
            output.add(A.get(i));
        }
        return output;
    }

    public static void main(String[] args) {
        int[] A = {-8, 8, -1, -16, -28, -27, 15, -14, 14, -27, -5, -6, -25, -11, 28, 29, -3, -25, 17, -25, 4, -20, 2, 1, -17, -10, -25};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(getLongestSequence(input));
    }
}
