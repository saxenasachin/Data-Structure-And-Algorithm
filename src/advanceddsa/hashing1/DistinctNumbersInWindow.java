package advanceddsa.hashing1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * Problem Description
 * You are given an array of N integers, A1, A2 ,..., AN and an integer B. Return the of count of distinct numbers in all windows of size B.
 * <p>
 * Formally, return an array of size N-B+1 where i'th element in this array contains number of distinct elements in sequence Ai, Ai+1 ,..., Ai+B-1.
 * <p>
 * NOTE: if B > N, return an empty array.
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 1, 3, 4, 3]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 1, 2, 2]
 * B = 1
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [2, 3, 3, 2]
 * Output 2:
 * <p>
 * [1, 1, 1, 1]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * A=[1, 2, 1, 3, 4, 3] and B = 3
 * All windows of size B are
 * [1, 2, 1]
 * [2, 1, 3]
 * [1, 3, 4]
 * [3, 4, 3]
 * So, we return an array [2, 3, 3, 2].
 * Explanation 2:
 * <p>
 * Window size is 1, so the output array is [1, 1, 1, 1].
 */
public class DistinctNumbersInWindow {

    public static ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        ArrayList<Integer> window = new ArrayList<>(); // Crete a window of size B;
        for (int i = 0; i < B; i++) { // Store all elements in window
            window.add(A.get(i));
        }
        output.add(countOfUniqueNumbers(window)); // store unique elements count in output list
        // iterate remaining elements one by one, remove an element from start
        // and add one element at end and calculate unique count of elements.
        for (int i = B; i < A.size(); i++) {
            window.remove(i - B);
            window.add(A.get(i));
            output.add(countOfUniqueNumbers(window));
        }
        return output;
    }

    /**
     *
     * @param A - input list
     * @return - no of unique elements
     */
    private static int countOfUniqueNumbers(ArrayList<Integer> A) {
        Set<Integer> set = new HashSet<>(A);
        return set.size();
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 1, 3, 4, 3};
        int B = 3;
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(dNums(input, B));
    }
}
