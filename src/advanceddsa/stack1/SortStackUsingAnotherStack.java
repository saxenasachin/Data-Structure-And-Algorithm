package advanceddsa.stack1;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Problem Description
 * Given a stack of integers A, sort it using another stack.
 * <p>
 * Return the array of integers after sorting the stack using another stack.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 5000
 * <p>
 * 0 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument is a stack given as an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the array of integers after sorting the stack using another stack.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [5, 4, 3, 2, 1]
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3, 4, 5]
 * Output 2:
 * <p>
 * [5, 11, 17, 100]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Just sort the given numbers.
 * Explanation 2:
 * <p>
 * Just sort the given numbers.
 */
public class SortStackUsingAnotherStack {

    public static ArrayList<Integer> solve(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        for (Integer i : A) {
            stack.push(i);
        }
        Stack<Integer> intermediate = new Stack<>();
        while (!stack.isEmpty()) {
            Integer number = stack.pop();
            if (!intermediate.isEmpty() && intermediate.peek() > number) {
                while (!intermediate.isEmpty() && intermediate.peek() > number) {
                    Integer topElement = intermediate.pop();
                    stack.push(topElement);
                }
                intermediate.push(number);
            } else {
                intermediate.push(number);
            }
        }
        return new ArrayList<>(intermediate);
    }

    public static void main(String[] args) {
        ArrayList<Integer> input = new ArrayList<>();
        // A = [5, 4, 3, 2, 1]
        input.add(5);
        input.add(17);
        input.add(100);
        input.add(11);
        System.out.println(solve(input));
    }
}
