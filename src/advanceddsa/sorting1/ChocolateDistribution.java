package advanceddsa.sorting1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * <p>
 * Given an array A of N integers where each value represents number of chocolates in a packet.
 * <p>
 * i-th can have A[i] number of chocolates.
 * <p>
 * There are B number students, the task is to distribute chocolate packets following below conditions:
 * <p>
 * 1. Each student gets one packet.
 * 2. The difference between the number of chocolates in packet with maximum chocolates and packet with minimum chocolates given to the students is minimum.
 * Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= N <= 10^5
 * 1 <= A[i] <= 10^7
 * 0 <= B <= 10^5
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument contains an integer array A.
 * <p>
 * The second argument contains an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return the minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input:
 * <p>
 * A : [3, 4, 1, 9, 56, 7, 9, 12]
 * B : 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation:
 * <p>
 * Minimum Difference is 6
 * The set goes like 3,4,7,9,9 and the output is 9-3 = 6
 */
public class ChocolateDistribution {

    /**
     * An efficient solution is based on the observation that to minimize the difference,
     * we must choose consecutive elements from a sorted packet.
     * We first sort the array arr[0..n-1],
     * then find the subarray of size m with the minimum difference between the last and first elements.
     * @param A - list where each value represents number of chocolates in a packet.
     * @param B - number of students
     * @return - minimum difference (that can be achieved) between maximum and minimum number of chocolates distributed.
     */
    public static int solve(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int minDifference = Integer.MAX_VALUE;
        int n = A.size();
        int i = 0;
        int j = B - 1;
        while (j < n) {
            minDifference = Math.min(minDifference, A.get(j) - A.get(i));
            i++;
            j++;
        }
        return minDifference;
     }

    public static void main(String[] args) {
        int[] A = {3, 4, 1, 9, 56, 7, 9, 12};
        int B = 5;
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(solve(input, B));
    }
}
