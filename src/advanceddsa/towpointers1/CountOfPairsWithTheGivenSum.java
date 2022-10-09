package advanceddsa.towpointers1;

import java.util.ArrayList;

/**
 * Given a sorted array of distinct integers A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 * <p>
 * <p>
 * Input Format
 * <p>
 * The first argument given is the integer array A.
 * The second argument given is integer B.
 * Output Format
 * <p>
 * Return the number of pairs for which sum is equal to B.
 * Constraints
 * <p>
 * 1 <= length of the array <= 100000
 * 1 <= A[i] <= 10^9
 * 1 <= B <= 10^9
 * For Example
 * <p>
 * Input 1:
 * A = [1, 2, 3, 4, 5]
 * B = 5
 * Output 1:
 * 2
 * <p>
 * Input 2:
 * A = [5, 10, 20, 100, 105]
 * B = 110
 * Output 2:
 * 2
 */
public class CountOfPairsWithTheGivenSum {

    /**
     * Take from pointers one from start and one from end,
     * move both pointers such that sum of the elements at two pointers are equal to given sum.
     *
     * @param A - input array
     * @param B - sum
     * @return - count of pairs
     */
    public static int getCountOfPairs(ArrayList<Integer> A, int B) {
        int i = 0;
        int j = A.size() - 1;
        int count = 0;
        while (i < j) {
            int sum = A.get(i) + A.get(j);
            if (sum > B) {
                j--;
            } else if (sum < B) {
                i++;
            } else {
                count++;
                i++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 3, 4, 5};
        int B = 5;
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(getCountOfPairs(input, B));
    }
}
