package advanceddsa.hashing1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Shaggy has an array A consisting of N elements. We call a pair of distinct indices in that array a special if elements at those indices in the array are equal.
 * <p>
 * Shaggy wants you to find a special pair such that the distance between that pair is minimum. Distance between two indices is defined as |i-j|. If there is no special pair in the array, then return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and only argument is an integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return one integer corresponding to the minimum possible distance between a special pair.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [7, 1, 3, 4, 1, 7]
 * Input 2:
 * <p>
 * A = [1, 1]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Here we have 2 options:
 * 1. A[1] and A[4] are both 1 so (1,4) is a special pair and |1-4|=3.
 * 2. A[0] and A[5] are both 7 so (0,5) is a special pair and |0-5|=5.
 * Therefore the minimum possible distance is 3.
 * Explanation 2:
 * <p>
 * Only possibility is choosing A[1] and A[2].
 */
public class ShaggyAndDistances {

    /**
     * Iterate over array if not found in amp, put it with index,
     * otherwise calculate distance and replace it with new index for min distance.
     * If we have to find max distance, we will not replace with new index. (Keep oldest index in map)
     *
     * @param A - input array
     * @return - min distance between two equal number otherwise -1
     */
    private static int findSpecialPairDistance(ArrayList<Integer> A) {
        Map<Integer, Integer> map = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (map.containsKey(A.get(i))) {
                minDistance = Math.min(minDistance, i - map.get(A.get(i)));
                map.put(A.get(i), i);
            } else {
                map.put(A.get(i), i);
            }
        }
        if (minDistance == Integer.MAX_VALUE) return -1;
        return minDistance;
    }

    public static void main(String[] args) {
        int[] A = {7, 1, 3, 4, 1, 7};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(findSpecialPairDistance(input));
    }
}
