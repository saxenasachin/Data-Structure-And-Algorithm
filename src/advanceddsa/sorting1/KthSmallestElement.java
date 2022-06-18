package advanceddsa.sorting1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Problem Description
 * Find the Bth smallest element in given array A .
 * <p>
 * NOTE: Users should try to solve it in less than equal to B swaps.
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= B <= min(|A|, 500)
 * <p>
 * 1 <= A[i] <= 109
 * <p>
 * Input Format
 * The first argument is an integer array A.
 * <p>
 * The second argument is integer B.
 * <p>
 * Output Format
 * Return the Bth smallest element in given array.
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [2, 1, 4, 3, 2]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2]
 * B = 2
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 3rd element after sorting is 2.
 * Explanation 2:
 * <p>
 * 2nd element after sorting is 2.
 */
public class KthSmallestElement {
    public static int kthSmallest(final List<Integer> A, int B) {
        List<Integer> list = new ArrayList<>(A);
        int n = list.size(); // size of array
        for (int i = 0; i < B; i++) { // loop till B (swaps)
            int minIndex = -1;
            int min = Integer.MAX_VALUE;
            for (int j = i; j < n; j++) {
                // find min element array from i to n and place this element to starting i.e. Selection sort
               if (list.get(j) < min) {
                   min = list.get(j);
                   minIndex = j;
               }
            }
            if (minIndex != -1) {
                swap(i, minIndex, list);
            }
        }
        return list.get(B - 1);
    }

    private static void swap(int i, int j, List<Integer> list) {
        int temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    public static void main(String[] args) {
        int[] A = {
                8, 16, 80, 55, 32, 8, 38, 40, 65, 18, 15,
                45, 50, 38, 54, 52, 23, 74, 81, 42, 28, 16,
                66, 35, 91, 36, 44, 9, 85, 58, 59, 49, 75,
                20, 87, 60, 17, 11, 39, 62, 20, 17, 46, 26, 81, 92
        };
        List<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        int ans = kthSmallest(input, 9);
        System.out.println(ans);
    }
}
