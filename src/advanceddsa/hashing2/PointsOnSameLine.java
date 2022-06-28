package advanceddsa.hashing2;

import java.util.*;

/**
 * Problem Description
 * Given two arrays of integers A and B describing a pair of (A[i], B[i]) coordinates in a 2D plane. A[i] describe x coordinates of the ith point in the 2D plane, whereas B[i] describes the y-coordinate of the ith point in the 2D plane.
 * <p>
 * Find and return the maximum number of points that lie on the same line.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= (length of the array A = length of array B) <= 1000
 * <p>
 * -105 <= A[i], B[i] <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument is an integer array A.
 * The second argument is an integer array B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the maximum number of points which lie on the same line.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [-1, 0, 1, 2, 3, 3]
 * B = [1, 0, 1, 2, 3, 4]
 * Input 2:
 * <p>
 * A = [3, 1, 4, 5, 7, -9, -8, 6]
 * B = [4, -8, -3, -2, -1, 5, 7, -4]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 2
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * The maximum number of point which lie on same line are 4, those points are {0, 0}, {1, 1}, {2, 2}, {3, 3}.
 * Explanation 2:
 * <p>
 * Any 2 points lie on a same line.
 */
public class PointsOnSameLine {

    /**
     * Here we use concept of slope with x-axis, slope = (y2 - y2) / (x2 - x1)
     * for every point, we check with all the other points with same slope
     * after counting, add 1 to final count, let x1 has same slope value with x2 and x3,
     * then total points will be 2 not one i.e. x1, x2 and x3.
     *
     * @param A x-coordinates
     * @param B y-coordinates
     * @return - maximum number of point on same line
     */
    public static int solve(List<Integer> A, List<Integer> B) {
        int maxPoint = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            int x1 = A.get(i);
            int y1 = B.get(i);

            // create map to store coordinates
            Map<String, Integer> coordinateMap = new HashMap<>();

            int countOfEqualPair = 1; // handle separately for (0, 0)
            // check slope of this coordinate with all other points and count.
            for (int j = i + 1; j < A.size(); j++) {

                int x2 = A.get(j);
                int y2 = B.get(j);

                if (x1 == x2 && y1 == y2) {
                    countOfEqualPair++;
                } else {
                    int numerator = y1 - y2;
                    int denominator = x1 - x2;

                    int gcd = gcd(numerator, denominator);

                    String key = (numerator / gcd) + "_" + (denominator / gcd);
                    coordinateMap.put(key, coordinateMap.getOrDefault(key, 0) + 1);
                }
            }

            maxPoint = Math.max(maxPoint, countOfEqualPair);

            for (Map.Entry<String, Integer> me : coordinateMap.entrySet()) {
                int value = me.getValue();
                maxPoint = Math.max(maxPoint, value + countOfEqualPair);
            }

            coordinateMap.clear();
        }

        return maxPoint;
    }

    private static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 1, 2, 3, 3};
        int[] B = {1, 0, 1, 2, 3, 4};
        List<Integer> listA = Arrays.stream(A).boxed().toList();
        List<Integer> listB = Arrays.stream(B).boxed().toList();
        System.out.println(solve(listA, listB));
    }
}
