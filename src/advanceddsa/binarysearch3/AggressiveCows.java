package advanceddsa.binarysearch3;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Problem Description
 * Farmer John has built a new long barn with N stalls. Given an array of integers A of size N where each element of the array represents the location of the stall and an integer B which represents the number of cows.
 * <p>
 * His cows don't like this barn layout and become aggressive towards each other once put into a stall. To prevent the cows from hurting each other, John wants to assign the cows to the stalls, such that the minimum distance between any two of them is as large as possible. What is the largest minimum distance?
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 2 <= N <= 100000
 * 0 <= A[i] <= 109
 * 2 <= B <= N
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * The second argument given is the integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the largest minimum distance possible among the cows.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 3, 4, 5]
 * B = 3
 * Input 2:
 * <p>
 * A = [1, 2]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * John can assign the stalls at location 1, 3 and 5 to the 3 cows respectively. So the minimum distance will be 2.
 * Explanation 2:
 * <p>
 * The minimum distance will be 1.
 */
public class AggressiveCows {

    public static int getLargestMinimum(ArrayList<Integer> A, int B) {
        Collections.sort(A);
        int n = A.size();
        int l = Integer.MAX_VALUE;
        int r = A.get(n - 1) - A.get(0);
        for (int i = 0; i < n - 1; i++) {
            l = Math.min(l, A.get(i + 1) - A.get(i));
        }
        int ans = l;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (check(A, mid, B)) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }

    private static boolean check(ArrayList<Integer> A, int minDistance, int cows) {
        int count = 0;
        int lastPlace = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i) - lastPlace >= minDistance) {
                count += 1;
                lastPlace = A.get(i);
            }
        }
        return count >= cows;
    }

    public static void main(String[] args) {
        int[] A = {71, 83, 65, 68, 21, 73, 94, 4, 68, 80, 24, 2, 46, 91, 59, 31, 11, 63, 65, 45, 18, 1, 92, 84, 41, 10, 35, 18, 48, 60, 90, 6, 8, 97, 32, 72, 72, 52, 11, 36, 92, 31, 75, 54, 71, 75, 75};
        int B = 21;

        ArrayList<Integer> input = new ArrayList<>();
        for (int a : A) {
            input.add(a);
        }
        System.out.println(getLargestMinimum(input, B));
    }
}
