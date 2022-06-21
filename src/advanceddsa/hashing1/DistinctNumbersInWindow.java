package advanceddsa.hashing1;

import java.util.*;

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
            window.remove(0);
            window.add(A.get(i));
            output.add(countOfUniqueNumbers(window));
        }
        return output;
    }

    /**
     * @param A - input list
     * @return - no of unique elements
     */
    private static int countOfUniqueNumbers(ArrayList<Integer> A) {
        Set<Integer> set = new HashSet<>(A);
        return set.size();
    }

    /**
     * Create an empty hash map. Let the hash map be hM.
     * Initialize the count of distinct elements as dist_count to 0.
     * Traverse through the first window and insert elements of the first window to hM. The elements are used as key and their counts as the value in hM. Also, keep updating dist_count
     * Print distinct count for the first window.
     * Traverse through the remaining array (or other windows).
     * Remove the first element of the previous window.
     * If the removed element appeared only once, remove it from hM and decrease the distinct count, i.e. do “dist_count–“
     * else (appeared multiple times in hM), then decrement its count in hM
     * Add the current element (last element of the new window)
     * If the added element is not present in hM, add it to hM and increase the distinct count, i.e. do “dist_count++”
     * Else (the added element appeared multiple times), increment its count in hM
     */
    public static ArrayList<Integer> getDistinctCount(ArrayList<Integer> A, int B) {
        ArrayList<Integer> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int distinctCount = 0;
        for (int i = 0; i < B; i++) { // Store all elements in window
            int num = A.get(i);
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(A.get(i), 1);
                distinctCount++;
            }
        }
        output.add(distinctCount);

        // iterate remaining elements one by one, remove an element from start
        // and add one element at end and calculate unique count of elements.
        for (int i = B; i < A.size(); i++) {
            int numToRemove = A.get(i - B);
            if (map.containsKey(numToRemove)) {
                if (map.get(numToRemove) > 1) {
                    map.put(numToRemove, map.get(numToRemove) - 1);
                } else {
                    map.remove(numToRemove);
                    distinctCount--;
                }
            }
            int numToAdd = A.get(i);
            if (map.containsKey(numToAdd)) {
                map.put(numToAdd, map.get(numToAdd) + 1);
            } else {
                map.put(numToAdd, 1);
                distinctCount++;
            }
            output.add(distinctCount);
        }
        return output;
    }

    public static void main(String[] args) {
        int[] A = {31, 51, 31, 51, 31, 31, 31, 31, 31, 31, 51, 31, 31};
        int B = 3;
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(getDistinctCount(input, B));
    }
}
