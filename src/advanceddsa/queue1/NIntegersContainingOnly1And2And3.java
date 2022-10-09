package advanceddsa.queue1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given an integer, A. Find and Return first positive A integers in ascending order containing only digits 1, 2, and 3.
 * <p>
 * NOTE: All the A integers will fit in 32-bit integers.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 29500
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the first positive A integers in ascending order containing only digits 1, 2 and 3.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * A = 7
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 3]
 * Output 2:
 * <p>
 * [1, 2, 3, 11, 12, 13, 21]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 * Explanation 2:
 * <p>
 * Output denotes the first 3 integers that contains only digits 1, 2 and 3.
 */
public class NIntegersContainingOnly1And2And3 {

    public static ArrayList<Integer> solve(int A) {
        ArrayList<Integer> output = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        queue.offer(2);
        queue.offer(3);

        while (output.size() < A) { // run this loop output list size is not equal to A

            int front = queue.remove();
            output.add(front);

            queue.offer(front * 10 + 1); // generate next first number and add to queue
            queue.offer(front * 10 + 2); // generate next second number and add to queue
            queue.offer(front * 10 + 3); // generate next third number and add to queue
        }
        return output;
    }

    public static void main(String[] args) {
        int  A = 7;
        System.out.println(solve(A));
    }
}
