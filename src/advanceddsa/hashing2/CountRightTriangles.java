package advanceddsa.hashing2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in 2D Cartesian plane.
 * <p>
 * Find and return the number of unordered triplets (i, j, k) such that (A[i], B[i]), (A[j], B[j]) and (A[k], B[k]) form a right-angled triangle with the triangle having one side parallel to the x-axis and one side parallel to the y-axis.
 * <p>
 * NOTE: The answer may be large so return the answer modulo (109 + 7).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * 0 <= A[i], B[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer array A.
 * The second argument given is the integer array B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the number of unordered triplets that form a right angled triangle modulo (109 + 7).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 1, 2]
 * B = [1, 2, 1]
 * Input 2:
 * <p>
 * A = [1, 1, 2, 3, 3]
 * B = [1, 2, 1, 2, 1]
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All three points make a right angled triangle. So return 1.
 * Explanation 2:
 * <p>
 * 6 triplets which make a right angled triangle are:    (1, 1), (1, 2), (2, 2)
 * (1, 1), (3, 1), (1, 2)
 * (1, 1), (3, 1), (3, 2)
 * (2, 1), (3, 1), (3, 2)
 * (1, 1), (1, 2), (3, 2)
 * (1, 2), (3, 1), (3, 2)
 */
public class CountRightTriangles {

    /**
     * take a point (x, y) as a center on which 90' angle is formed.
     * find all the points in y coordinates list, which has same y coordinate, let's say c1
     * all these y's are in same line of (x, y) - parallel to x-axis.
     * similarly find all points in x coordinates list, which has same x coordinate, let's say c2
     * all these x's are in same line of (x, y) - parallel to y-axis.
     * These points also includes the center of point which we consider.
     * so total number of right angles triangles will be (c1 - 1) * (c2 - 1)
     *
     * @param A - x coordinates list
     * @param B - y coordinates list
     * @return - count of right angled triangle
     */
    private static int getCountOfRightTriangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        // store all count of x and y coordinates in a separate map
        Map<Integer, Integer> xMap = new HashMap<>();
        for (Integer a : A) {
            xMap.put(a, xMap.getOrDefault(a, 0) + 1);
        }

        Map<Integer, Integer> yMap = new HashMap<>();
        for (Integer b : B) {
            yMap.put(b, yMap.getOrDefault(b, 0) + 1);
        }

        int count = 0;
        int mod = 1000000007;

        // Iterate over (x, y) and find total number of x and y coordinates in each map
        for (int i = 0; i < A.size(); i++) {
            int x = A.get(i);
            int y = B.get(i);
            int totalXCoordinates = xMap.getOrDefault(x, 0);
            int totalYCoordinates = yMap.getOrDefault(y, 0);
            count += ((totalXCoordinates - 1) * (totalYCoordinates - 1)) % mod;
        }

        return count % mod;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2};
        int[] b = {1, 2, 1};

        ArrayList<Integer> xCoordinates = new ArrayList<>();
        for (int i : a) {
            xCoordinates.add(i);
        }
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        for (int i : b) {
            yCoordinates.add(i);
        }
        System.out.println(getCountOfRightTriangles(xCoordinates, yCoordinates));
    }
}
