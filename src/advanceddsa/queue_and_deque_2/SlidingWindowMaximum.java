package advanceddsa.queue_and_deque_2;

import java.util.*;

/**
 * Problem Description
 * Given an array of integers A. There is a sliding window of size B, moving from the very left of the array to the very right. You can only see the B numbers in the window. Each time the sliding window moves rightwards by one position. You have to find the maximum for each window.
 * <p>
 * Return an array C, where C[i] is the maximum value in the array from A[i] to A[i+B-1].
 * <p>
 * Refer to the given example for clarity.
 * <p>
 * NOTE: If B > length of the array, return 1 element with the max of the array.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A|, B <= 106
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array C, where C[i] is the maximum value of from A[i] to A[i+B-1].
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 3, -1, -3, 5, 3, 6, 7]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2, 3, 4, 2, 7, 1, 3, 6]
 * B = 6
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [3, 3, 5, 5, 6, 7]
 * Output 2:
 * <p>
 * [7, 7, 7, 7]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Window position     | Max
 * --------------------|-------
 * [1 3 -1] -3 5 3 6 7 | 3
 * 1 [3 -1 -3] 5 3 6 7 | 3
 * 1 3 [-1 -3 5] 3 6 7 | 5
 * 1 3 -1 [-3 5 3] 6 7 | 5
 * 1 3 -1 -3 [5 3 6] 7 | 6
 * 1 3 -1 -3 5 [3 6 7] | 7
 * Explanation 2:
 * <p>
 * Window position     | Max
 * --------------------|-------
 * [1 2 3 4 2 7] 1 3 6 | 7
 * 1 [2 3 4 2 7 1] 3 6 | 7
 * 1 2 [3 4 2 7 1 3] 6 | 7
 * 1 2 3 [4 2 7 1 3 6] | 7
 */
public class SlidingWindowMaximum {

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < B - 1; i++) {
            int number = A.get(i);
            while (!queue.isEmpty() && queue.peekLast() < number) {
                queue.removeLast();
            }
            queue.addLast(number);
        }

        int j = -1;
        int k = B - 1;

        while (k <= A.size() - 1) {
            int next = A.get(k);
            while (!queue.isEmpty() && queue.peekLast() < next) {
                queue.removeLast();
            }
            queue.addLast(next);

            if (j >= 0 && Objects.equals(queue.peekFirst(), A.get(j))) {
                queue.removeFirst();
            }

            output.add(queue.peekFirst());

            j++;
            k++;
        }

        return output;
    }

    public static void main(String[] args) {
        int[] A = {1, 3, -1, -3, 5, 3, 6, 7};
        List<Integer> listA = Arrays.stream(A).boxed().toList();
        int B = 3;
        System.out.println(slidingMaximum(listA, B));
    }
}
