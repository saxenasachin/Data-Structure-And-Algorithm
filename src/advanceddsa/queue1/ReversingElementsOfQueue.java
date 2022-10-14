package advanceddsa.queue1;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem Description
 * Given an array of integers A and an integer B, we need to reverse the order of the first B elements of the array, leaving the other elements in the same relative order.
 * <p>
 * NOTE: You are required to the first insert elements into an auxiliary queue then perform Reversal of first B elements.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= B <= length of the array <= 500000
 * 1 <= A[i] <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The argument given is the integer array A and an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array of integer after reversing the first B elements of A using queue.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 * <p>
 * A = [5, 17, 100, 11]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [3, 2, 1, 4, 5]
 * Output 2:
 * <p>
 * [17, 5, 100, 11]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Reverse first 3 elements so the array becomes [3, 2, 1, 4, 5]
 * Explanation 2:
 * <p>
 * Reverse first 2 elements so the array becomes [17, 5, 100, 11]
 */
public class ReversingElementsOfQueue {

    public static int[] solve(int[] A, int B) {

        Deque<Integer> deque = new ArrayDeque<>(A.length);

        int i;
        for (i = 0; i < B; i++)
            deque.addLast(A[i]);

        while (deque.size() > 0) {
            i--;
            A[i] = deque.removeFirst();
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 3;
        System.out.println(Arrays.toString(solve(A, B)));
    }
}
