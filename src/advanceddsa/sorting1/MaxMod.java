package advanceddsa.sorting1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Problem Description
 * Given an array A of size N, Groot wants you to pick 2 indices i and j such that
 * <p>
 * 1 <= i, j <= N
 * A[i] % A[j] is maximum among all possible pairs of (i, j).
 * Help Groot in finding the maximum value of A[i] % A[j] for some i, j.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * 0 <= A[i] <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument in an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the maximum value of A[i] % A[j] for any valid i, j.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 44, 3]
 * Input 2:
 * <p>
 * A = [2, 6, 4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 4
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * For i = 3, j = 2  A[i] % A[j] = 3 % 44 = 3.
 * No pair exists which has more value than 3.
 * Explanation 2:
 * <p>
 * For i = 2, j = 1  A[i] % A[j] = 4 % 6 = 4.
 */
public class MaxMod {

    public static int solve(ArrayList<Integer> A) {
        Collections.sort(A);
        int maxMod = Integer.MIN_VALUE;
        int n = A.size();
        int j = A.get(n - 1);
        int i = n - 2;
        while (i >= 0) {
            if (!Objects.equals(A.get(i), A.get(i + 1))) {
                break;
            } else {
                i--;
            }
        }
        return A.get(i) % j;
    }

    public static void main(String[] args) {
        int[] A = {927, 707, 374, 394, 279, 799, 878, 937, 431, 112};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(solve(input));
    }
}
