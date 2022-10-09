package advanceddsa.twopointers1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * Problem Description
 * Given an one-dimensional integer array A of size N and an integer B.
 * <p>
 * Count all distinct pairs with difference equal to B.
 * <p>
 * Here a pair is defined as an integer pair (x, y), where x and y are both numbers in the array and their absolute difference is B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 104
 * <p>
 * 0 <= A[i], B <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an one-dimensional integer array A of size N.
 * <p>
 * Second argument is an integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer denoting the count of all distinct pairs with difference equal to B.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 5, 3, 4, 2]
 * B = 3
 * Input 2:
 * <p>
 * A = [8, 12, 16, 4, 0, 20]
 * B = 4
 * Input 3:
 * <p>
 * A = [1, 1, 1, 2, 2]
 * B = 0
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 5
 * Output 3:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * There are 2 unique pairs with difference 3, the pairs are {1, 4} and {5, 2}
 * Explanation 2:
 * <p>
 * There are 5 unique pairs with difference 4, the pairs are {0, 4}, {4, 8}, {8, 12}, {12, 16} and {16, 20}
 * Explanation 3:
 * <p>
 * There are 2 unique pairs with difference 0, the pairs are {1, 1} and {2, 2}.
 */
public class PairsWithGivenDifference {

    public static int solve(ArrayList<Integer> A, int B) {
        int countOfPairs = 0;
        Collections.sort(A);
        int i = 0;
        int j = A.size() - 1;

        while (i < j) {
            int element1 = A.get(i);
            int element2 = A.get(j);
            int difference = Math.abs(element1 - element2);
            if (difference == B) {
                if (Objects.equals(A.get(i), A.get(j))) {

                } else {
                    int rightPointer = j;
                    while (rightPointer > i && Objects.equals(A.get(rightPointer), A.get(j))) {
                        rightPointer--;
                        countOfPairs++;
                    }
                    j = rightPointer;
                }
            } else if (difference > B) {
                j--;
            } else {
                i++;
            }
        }

        return countOfPairs;
    }

    public static void main(String[] args) {
        int[] A = {8, 12, 16, 4, 0, 20};
        int B = 4;
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(solve(input, B));
    }
}
