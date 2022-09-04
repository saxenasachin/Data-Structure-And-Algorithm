package advanceddsa.queue_and_deque_2;

import java.util.*;

/**
 * roblem Description
 * Given an array A of both positive and negative integers.
 * <p>
 * Your task is to compute the sum of minimum and maximum elements of all sub-array of size B.
 * <p>
 * NOTE: Since the answer can be very large, you are required to return the sum modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= size of array A <= 105
 * <p>
 * -109 <= A[i] <= 109
 * <p>
 * 1 <= B <= size of array
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument denotes the integer array A.
 * The second argument denotes the value B
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer that denotes the required value.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 5, -1, 7, -3, -1, -2]
 * B = 4
 * Input 2:
 * <p>
 * A = [2, -1, 3]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 18
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Subarrays of size 4 are :
 * [2, 5, -1, 7],   min + max = -1 + 7 = 6
 * [5, -1, 7, -3],  min + max = -3 + 7 = 4
 * [-1, 7, -3, -1], min + max = -3 + 7 = 4
 * [7, -3, -1, -2], min + max = -3 + 7 = 4
 * Sum of all min & max = 6 + 4 + 4 + 4 = 18
 * Explanation 2:
 * <p>
 * Subarrays of size 2 are :
 * [2, -1],   min + max = -1 + 2 = 1
 * [-1, 3],   min + max = -1 + 3 = 2
 * Sum of all min & max = 1 + 2 = 3
 */
public class SumOfMinAndMax {

    public static int solve(List<Integer> A, int B) {
        ArrayList<Integer> slidingMaximum = SlidingWindowMaximum.slidingMaximum(A, B);
        ArrayList<Integer> slidingMinimum = slidingMinimum(A, B);
        int result = 0;
        int mod = 1000000007;
        for (int i = 0; i < slidingMinimum.size(); i++) {
            result += slidingMaximum.get(i) + slidingMinimum.get(i);
            result %= mod;
        }
        return result;
    }

    public static ArrayList<Integer> slidingMinimum(final List<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        Deque<Integer> queue = new LinkedList<>();
        for (int i = 0; i < B - 1; i++) {
            int number = A.get(i);
            while (!queue.isEmpty() && queue.peekLast() > number) {
                queue.removeLast();
            }
            queue.addLast(number);
        }

        int j = -1;
        int k = B - 1;

        while (k <= A.size() - 1) {
            int next = A.get(k);
            while (!queue.isEmpty() && queue.peekLast() > next) {
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
        int[] A = {2, 5, -1, 7, -3, -1, -2};
        int B = 4;
        List<Integer> listA = Arrays.stream(A).boxed().toList();
        System.out.println(solve(listA, B));
    }
}
