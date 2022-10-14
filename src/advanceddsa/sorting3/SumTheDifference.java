package advanceddsa.sorting3;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Problem Description
 * Given an integer array, A of size N.
 * You have to find all possible non-empty subsequences of the array of numbers and then, for each subsequence, find the difference between the largest and smallest numbers in that subsequence. Then add up all the differences to get the number.
 * <p>
 * As the number may be large, output the number modulo 1e9 + 7 (1000000007).
 * <p>
 * NOTE: Subsequence can be non-contiguous.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 10000
 * <p>
 * 1<= A[i] <=1000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the output.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2]
 * Input 2:
 * <p>
 * A = [1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All possible non-empty subsets are:
 * [1]    largest-smallest = 1 - 1 = 0
 * [2]    largest-smallest = 2 - 2 = 0
 * [1 2]  largest-smallest = 2 - 1 = 1
 * Sum of the differences = 0 + 0 + 1 = 1
 * So, the resultant number is 1
 * Explanation 2:
 * <p>
 * Only 1 subsequence of 1 element is formed.
 */
public class SumTheDifference {

    /**
     * We can drive an equation for ex for array [a, b, c, d] and n = 4,a
     * [pow(2, 3) * a + pow(2, 2) * b + pow(2, 1) * c + pow(2, 0) * d] - [pow(2, 0) * a + pow(2, 1) * b + pow(2, 2) * c + pow(2, 3) * d]
     *
     * @param A - input array
     * @return - sum of all differences between max and min elements in all subsequences
     */
    public static int solve(List<Integer> A) {

        // sort the array as order does not matter in case of finding difference between largest and smallest element in subsequences.
        Collections.sort(A);

        int mod = 1000 * 1000 * 1000 + 7;
        int min = 0;
        int max = 0;
        int n = A.size();

        for (Integer integer : A) {
            min *= 2;
            min += integer;
            min %= mod;
        }

        for (int i = n - 1; i >= 0; i--) {
            max *= 2;
            max += A.get(i);
            max %= mod;
        }

        return (max - min + mod) % mod;
    }

    public static void main(String[] args) {
        int[] A = {1};
        List<Integer> listA = Arrays.stream(A).boxed().collect(Collectors.toList());
        System.out.println(solve(listA));
    }
}
