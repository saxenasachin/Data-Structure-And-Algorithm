package advanceddsa.hashing2;

import java.util.*;

/**
 * Problem Description
 * Given an array A of length N. You have to answer Q queries.
 * <p>
 * Each query will contain four integers l1, r1, l2, and r2. If sorted segment from [l1, r1] is the same as the sorted segment from [l2 r2], then the answer is 1 else 0.
 * <p>
 * NOTE The queries are 0-indexed.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 0 <= A[i] <= 100000
 * 1 <= N <= 100000
 * 1 <= Q <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an array A.
 * The second is a 2D array B denoting queries with dimension Q * 4.
 * Consider ith query as l1 = B[i][0], r1 = B[i][1], l2 = A[i][2], r2 = B[i][3].
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an array of length Q with answers to the queries in the same order as the input.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 7, 11, 8, 11, 7, 1]
 * B = [
 * [0, 2, 4, 6]
 * ]
 * Input 2:
 * <p>
 * A = [1, 3, 2]
 * B = [
 * [0, 1, 1, 2]
 * ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1]
 * Output 2:
 * <p>
 * [0]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * (0, 2) -> [1, 7, 11]
 * (4, 6) -> [11, 7, 1]
 * Both are same when sorted hence 1.
 * Explanation 2:
 * <p>
 * (0, 1) -> [1, 3]
 * (1, 2) -> [3, 2]
 * Both are different when sorted hence 0.
 */
public class CompareSortedSubarrays {

    /**
     * maintain prefix sum array by using hash value for each element in array.
     * if sum of both subarray are equal then subarray are equal otherwise not.
     * generating large hash value is necessary because [4, 6] == [3, 7].
     * if the length of subarrays are not equal then add 0 in the output and continue to check further.
     *
     * @param A - input array
     * @param B - number of queries
     * @return - list containing output depict whether subarray are equal or not
     */
    public static ArrayList<Integer> solve(List<Integer> A, List<List<Integer>> B) {
        ArrayList<Integer> output = new ArrayList<>();

        // map containing hash value for the numbers present in array.
        Map<Integer, Long> hashMap = setHash(A);

        // create prefix sum array
        long[] prefixSum = new long[A.size()];
        prefixSum[0] = hashMap.get(A.get(0));
        for (int i = 1; i < A.size(); i++) {
            prefixSum[i] = prefixSum[i - 1] + hashMap.get(A.get(i));
        }

        // iterate for each query
        for (List<Integer> list : B) {
            int l1 = list.get(0);
            int r1 = list.get(1);
            int l2 = list.get(2);
            int r2 = list.get(3);

            if (r1 - l1 + 1 != r2 - l2 + 1) { // if lenght is not equal, no need to check further.
                output.add(0);
                continue;
            }

            long sum1;
            if (l1 == 0) {
                sum1 = prefixSum[r1];
            } else {
                sum1 = prefixSum[r1] - prefixSum[l1 - 1];
            }

            long sum2;
            if (l2 == 0) {
                sum2 = prefixSum[r2];
            } else {
                sum2 = prefixSum[r2] - prefixSum[l2 - 1];
            }

            if (sum1 == sum2) {
                output.add(1);
            } else {
                output.add(0);
            }
        }

        return output;
    }

    /**
     * generate large hash value for each number in given array
     *
     * @param A - input array
     * @return - map containing key - element of array, value - large hash value
     */
    private static Map<Integer, Long> setHash(List<Integer> A) {
        Map<Integer, Long> hashMap = new HashMap<>();
        long range = 1000L * 1000 * 1000 * 1000;
        for (Integer a : A) {
            if (!hashMap.containsKey(a)) {
                hashMap.put(a, (long) (Math.random() * range + 1));
            }
        }
        return hashMap;
    }

    public static void main(String[] args) {
        int[] A = {100000, 100000, 100000, 100000, 100000};
        int[][] B1 = {
                {0, 3, 1, 4},
                {0, 1, 2, 3},
                {4, 4, 1, 1},
                {1, 3, 0, 0},
                {2, 4, 1, 1}
        };
        List<Integer> listA = Arrays.stream(A).boxed().toList();
        List<List<Integer>> listB = new ArrayList<>();
        for (int[] array : B1) {
            listB.add(Arrays.stream(array).boxed().toList());
        }
        System.out.println(solve(listA, listB));
    }
}
