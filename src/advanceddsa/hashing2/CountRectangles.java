package advanceddsa.hashing2;

import javafx.util.Pair;

import java.util.*;

/**
 * Problem Description
 * Given two arrays of integers A and B of size N each, where each pair (A[i], B[i]) for 0 <= i < N represents a unique point (x, y) in a 2-D Cartesian plane.
 * <p>
 * Find and return the number of unordered quadruplet (i, j, k, l) such that (A[i], B[i]), (A[j], B[j]), (A[k], B[k]) and (A[l], B[l]) form a rectangle with the rectangle having all the sides parallel to either x-axis or y-axis.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 2000
 * 0 <= A[i], B[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer array B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the number of unordered quadruplets that form a rectangle.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 1, 2, 2]
 * B = [1, 2, 1, 2]
 * Input 1:
 * <p>
 * A = [1, 1, 2, 2, 3, 3]
 * B = [1, 2, 1, 2, 1, 2]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 3
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * All four given points make a rectangle. So, the answer is 1.
 * Explanation 2:
 * <p>
 * 3 quadruplets which make a rectangle are: (1, 1), (2, 1), (2, 2), (1, 2)
 * (1, 1), (3, 1), (3, 2), (1, 2)
 * (2, 1), (3, 1), (3, 2), (2, 2)
 */
public class CountRectangles {

    /**
     * (x1, y1) (x2, y2) (x3, y3) (x4, y4)
     * find diagonal points (x1, y1) and (x2, y2), to be diagonal points,
     * x1 != x2 and y1 != y2.
     * Two other points of a rectangle will be (x1, y2) and (x2, y1).
     * Check if these points exists or not.
     * if exists, it makes rectangle. count = count + 1.
     * In the processing of finding rectangle counts, we will come across both diagonals
     * of a rectangle, i.e. we will count same rectangle twice.
     * so after finding total counts of rectangle, return (count / 2).
     *
     * @param A - list of x coordinates
     * @param B - list of y coordinates
     * @return - count of rectangles
     */
    private static int getCountOfRectangles(ArrayList<Integer> A, ArrayList<Integer> B) {
        // use TreeSet class because it supports non-primitive data types as well, as we need to store (x, y).
        Set<Pair<Integer, Integer>> set = new TreeSet<>((o1, o2) -> {
            // Override comparator - use sum of (pair.key + pair.value) for comparing
            int x1 = o1.getKey(); // first key
            int y1 = o1.getValue(); // first value
            int x2 = o2.getKey(); // second key
            int y2 = o2.getValue(); // second value
            return Integer.compare(x1 + y1, x2 + y2);
        });

        // store all the pairs in set
        for (int i = 0; i < A.size(); i++) {
            set.add(new Pair<>(A.get(i), B.get(i)));
        }

        int count = 0; // count of rectangles
        // use two loop to check for every two points whether it is diagonal points
        for (int i = 0; i < A.size(); i++) {
            for (int j = i + 1; j < A.size(); j++) {
                int x1 = A.get(i);
                int y1 = B.get(i);
                int x2 = A.get(j);
                int y2 = B.get(j);

                // check for diagonal elements, if not continue
                if (x1 == x2 || y1 == y2) continue;

                // Check for these pairs in set whether it exists or not (these are other coordinates)
                Pair<Integer, Integer> firstPoint = new Pair<>(x1, y2);
                Pair<Integer, Integer> secondPoint = new Pair<>(x2, y1);
                if (set.contains(firstPoint) && set.contains(secondPoint)) {
                    count++;
                }
            }
        }

        return count / 2;
    }

    public static void main(String[] args) {
        int[] a = {1, 1, 2, 2, 3, 3};
        int[] b = {1, 2, 1, 2, 1, 2};
        ArrayList<Integer> A = new ArrayList<>();
        for (int i : a) {
            A.add(i);
        }
        ArrayList<Integer> B = new ArrayList<>();
        for (int i : b) {
            B.add(i);
        }
        System.out.println(getCountOfRectangles(A, B));
    }
}
