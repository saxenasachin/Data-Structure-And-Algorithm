package advanceddsa.stack2;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Given an array of integers A.
 * <p>
 * A represents a histogram i.e A[i] denotes the height of the ith histogram's bar. Width of each bar is 1.
 * <p>
 * Find the area of the largest rectangle formed by the histogram.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 1000000000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the area of the largest rectangle in the histogram.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 1, 5, 6, 2, 3]
 * Input 2:
 * <p>
 * A = [2]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 10
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The largest rectangle has area = 10 unit. Formed by A[3] to A[4].
 * Explanation 2:
 * <p>
 * Largest rectangle has area 2.
 */
public class LargestRectangleInHistogram {

    public static int largestRectangleArea(ArrayList<Integer> A) {
        // find nearest smallest index to left
        Stack<Integer> stack = new Stack<>();
        int[] NSL = new int[A.size()];
        for (int i = 0; i < A.size(); i++) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSL[i] = 0;
            } else {
                NSL[i] = stack.peek() + 1;
            }
            stack.push(i);
        }

        // find nearest smallest index to right
        // clear stack to reuse
        stack.clear();
        int[] NSR = new int[A.size()];
        for (int i = A.size() - 1; i >= 0; i--) {
            while (!stack.isEmpty() && A.get(stack.peek()) >= A.get(i)) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                NSR[i] = A.size() - 1;
            } else {
                NSR[i] = stack.peek() - 1;
            }
            stack.push(i);
        }

        // calculate area
        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            maxArea = Math.max(A.get(i) * (NSR[i] - NSL[i] + 1), maxArea);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] A = {2, 1, 5, 6, 2, 3};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(largestRectangleArea(input));
    }
}
