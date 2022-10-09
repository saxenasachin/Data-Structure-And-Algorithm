package advanceddsa.twopointers1;

import java.util.ArrayList;

/**
 * Problem Description
 * Given an array of positive integers A and an integer B, find and return first continuous subarray which adds to B.
 * <p>
 * If the answer does not exist return an array with a single element "-1".
 * <p>
 * First sub-array means the sub-array for which starting index in minimum.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 109
 * 1 <= B <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the first continuous sub-array which adds to B and if the answer does not exist return an array with a single element "-1".
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 5
 * Input 2:
 * <p>
 * A = [5, 10, 20, 100, 105]
 * B = 110
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 3]
 * Output 2:
 * <p>
 * -1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * [2, 3] sums up to 5.
 * Explanation 2:
 * <p>
 * No subarray sums up to required number.
 */
public class SubarrayWithGivenSum {

    /**
     * @param A - input array
     * @param B - given sum
     * @return - list of subarray elements whose sue is equal to given sum
     */
    public static ArrayList<Integer> solve(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        output.add(-1);
        int[] preSum = new int[A.size()];
        preSum[0] = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            preSum[i] = preSum[i - 1] + A.get(i);
        }

        int left = 0;
        int right = 1;
        int sum;

        while (left <= right && right < A.size()) {
            if (left == 0) {
                sum = preSum[right];
            } else {
                sum = preSum[right] - preSum[left - 1];
            }
            if (sum == B) {
                output.clear();
                for (int i = left; i <= right; i++) {
                    output.add(A.get(i));
                }
                break;
            } else if (sum > B) {
                left++;
            } else {
                right++;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] A = {
                1, 1000000000
        };
        int B = 1000000000;

        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }

        System.out.println(solve(input, B));
    }
}
