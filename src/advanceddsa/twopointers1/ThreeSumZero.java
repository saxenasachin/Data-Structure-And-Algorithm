package advanceddsa.twopointers1;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * <p>
 * Given an array A of N integers, are there elements a, b, c in S such that a + b + c = 0
 * <p>
 * Find all unique triplets in the array which gives the sum of zero.
 * <p>
 * Note:
 * <p>
 * Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c) The solution set must not contain duplicate triplets.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 0 <= N <= 7000
 * <p>
 * -108 <= A[i] <= 108
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * Single argument representing a 1-D array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Output a 2-D vector where each row represent a unique triplet.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * A = [-1,0,1,2,-1,4]
 * <p>
 * <p>
 * Example Output
 * <p>
 * [ [-1,0,1],
 * [-1,-1,2] ]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Out of all the possible triplets having total sum zero,only the above two triplets are unique.
 */
public class ThreeSumZero {

    public static ArrayList<ArrayList<Integer>> threeSum(ArrayList<Integer> A) {
        // a + b = c
        // a + b = -c
        // find pair whose sum is equal to -c i.e. same as two sum problem

        Collections.sort(A); // sort the array

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        int n = A.size();
        for (int i = 0; i < n - 2; i++) {
            int element = A.get(i);

            // find pair in remaining array whose sum is equal to -1 * element.
            int sum = -1 * element;

            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int first = A.get(left);
                int second = A.get(right);
                int pairSum = first + second;
                if (pairSum > sum) {
                    right--;
                } else if (pairSum < sum) {
                    left++;
                } else {
                    ArrayList<Integer> triplets = new ArrayList<>();
                    triplets.add(element);
                    triplets.add(first);
                    triplets.add(second);
                    Collections.sort(triplets);
                    if (!ans.contains(triplets)) { // add only if triplet not added already.
                        ans.add(triplets);
                    }
                    left++;
                    right--;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] A = {-1, 0, 1, 2, -1, 4};
        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(threeSum(input));
    }
}
