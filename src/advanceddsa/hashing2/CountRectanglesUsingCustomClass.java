package advanceddsa.hashing2;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

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
public class CountRectanglesUsingCustomClass {

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
        Set<CoordinatePair> set = new TreeSet<>();

        // store all the pairs in set
        for (int i = 0; i < A.size(); i++) {
            set.add(new CoordinatePair(A.get(i), B.get(i)));
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
                CoordinatePair firstPoint = new CoordinatePair(x1, y2);
                CoordinatePair secondPoint = new CoordinatePair(x2, y1);
                if (set.contains(firstPoint) && set.contains(secondPoint)) {
                    count++;
                }
            }
        }

        return count / 2;
    }

    static class CoordinatePair implements Comparable<CoordinatePair> {
        int x;
        int y;

        CoordinatePair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(@NotNull CoordinatePair o) {
            if (this.x == o.x) {
                return this.y - o.y;
            }
            return this.x - o.x;
        }
    }

    public static void main(String[] args) {
        int[] a = {38, 36, 48, 42, 36, 56, 38, 48, 40, 24, 48, 32, 22, 54, 22, 42, 34, 54, 52, 36, 52, 38, 36, 30, 30, 44, 46, 58, 56, 52, 48, 34, 36, 42, 50, 34, 28, 44, 44, 60, 56, 32, 48, 22, 56, 38, 42};
        int[] b = {58, 42, 30, 60, 50, 42, 40, 24, 54, 28, 52, 54, 28, 32, 42, 54, 38, 38, 54, 24, 30, 60, 44, 40, 26, 56, 28, 60, 34, 50, 48, 28, 56, 34, 48, 26, 30, 22, 52, 36, 24, 50, 42, 58, 54, 54, 48};

        ArrayList<Integer> xCoordinates = new ArrayList<>();
        for (int i : a) {
            xCoordinates.add(i);
        }
        ArrayList<Integer> yCoordinates = new ArrayList<>();
        for (int i : b) {
            yCoordinates.add(i);
        }
        System.out.println(getCountOfRectangles(xCoordinates, yCoordinates));
    }
}
