package advanceddsa.stack2;

import java.util.Stack;

/**
 * Problem Description
 * Given an integer array A of size N. You have to generate it's all subarrays having a size greater than 1.
 * <p>
 * Then for each subarray, find Bitwise XOR of its maximum and second maximum element.
 * <p>
 * Find and return the maximum value of XOR among all subarrays.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= N <= 105
 * <p>
 * 1 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer, i.e., the maximum value of XOR of maximum and 2nd maximum element among all subarrays.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 3, 1, 4]
 * Input 2:
 * <p>
 * A = [1, 3]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 7
 * <p>
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All subarrays of A having size greater than 1 are:
 * Subarray            XOR of maximum and 2nd maximum no.
 * 1. [2, 3]           1
 * 2. [2, 3, 1]        1
 * 3. [2, 3, 1, 4]     7
 * 4. [3, 1]           2
 * 5. [3, 1, 4]        7
 * 6. [1, 4]           5
 * So maximum value of Xor among all subarrays is 7.
 * Explanation 2:
 * <p>
 * Only subarray is [1, 3] and XOR of maximum and 2nd maximum is 2.
 */
public class AllSubarrays {

    public static int solve(int[] A) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        for (int i = 0; i < A.length; i++) {
            while (!stack.isEmpty()) {
                max = Math.max(max, A[i] ^ A[stack.peek()]);
                if (A[i] < A[stack.peek()]) {
                    break;
                }
                stack.pop();
            }
            stack.push(i);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] A = {2, 3, 1, 4};
        System.out.println(solve(A));
    }
}
