package advanceddsa.stack2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Given an array A, find the next greater element G[i] for every element A[i] in the array.
 * The next greater element for an element A[i] is the first greater element on the right side of A[i] in the array, A.
 * <p>
 * More formally:
 * <p>
 * G[i] for an element A[i] = an element A[j] such that
 * j is minimum possible AND
 * j > i AND
 * A[j] > A[i]
 * Elements for which no greater element exists, consider the next greater element as -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * 1 <= A[i] <= 107
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains the integer array, A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array representing the next greater element for each index in A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [4, 5, 2, 10]
 * Input 2:
 * <p>
 * A = [3, 2, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [5, 10, 10, -1]
 * Output 2:
 * <p>
 * [-1, -1, -1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * For 4, the next greater element towards its right is 5.
 * For 5 and 2, the next greater element towards their right is 10.
 * For 10, there is no next greater element towards its right.
 * Explanation 2:
 * <p>
 * As the array is in descending order, there is no next greater element for all the elements.
 */
public class NextGreater {

    public static ArrayList<Integer> nextGreater(ArrayList<Integer> A) {
        ArrayList<Integer> output = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                output.add(0, -1);
            } else {
                output.add(0, stack.peek());
            }
            stack.push(A.get(i));
        }
        return output;
    }

    public static void main(String[] args) {
        int[] A = {4, 5, 2, 10};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(nextGreater(input));
    }
}
