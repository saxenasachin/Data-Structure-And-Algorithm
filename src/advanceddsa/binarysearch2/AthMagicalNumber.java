package advanceddsa.binarysearch2;

import java.util.*;

/**
 * Problem Description
 * You are given three positive integers, A, B, and C.
 * <p>
 * Any positive integer is magical if divisible by either B or C.
 * <p>
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 109
 * <p>
 * 2 <= B, C <= 40000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is an integer A.
 * <p>
 * The second argument given is an integer B.
 * <p>
 * The third argument given is an integer C.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the Ath smallest magical number. Since the answer may be very large, return modulo 109 + 7.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = 1
 * B = 2
 * C = 3
 * Input 2:
 * <p>
 * A = 4
 * B = 2
 * C = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 2
 * Output 2:
 * <p>
 * 6
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * 1st magical number is 2.
 * Explanation 2:
 * <p>
 * First four magical numbers are 2, 3, 4, 6 so the 4th magical number is 6.
 */
public class AthMagicalNumber {

    /**
     * @param A - Ath magical number
     * @param B - first number
     * @param C - second number
     * @return - magical number
     * <p>
     * Brute force method - Store A magical number for B and C in a list
     * and sort them and return (A + 1)th index number
     */
    private static int bruteForceToGetMagicalNumber(int A, int B, int C) {
        Set<Integer> magicalList = new TreeSet<Integer>();
        for (int i = 1; i <= A; i++) {
            magicalList.add(B * i);
        }
        for (int i = 1; i <= A; i++) {
            magicalList.add(C * i);
        }
        return (int) magicalList.toArray()[A - 1];
    }

    /**
     * Use binary search
     * start = min(B, C) end = start * A, we will find Ath magical number until end.
     */
    private static int getMagicalNumber(int A, int B, int C) {
        long ans = -1;
        int mod = 1000000007;
        long start = Math.min(B, C);
        long end = start * A;
        long lcm = ((long) B * C) / gcd(B, C);
        while (start <= end) {
            long mid = start + (end - start) / 2;
            long magicalNumbers = (mid / B) + (mid / C) - (mid / lcm);
            if (magicalNumbers == A) {
                ans = mid;
                ans %= mod;
                end = mid - 1;
            } else if (magicalNumbers < A) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return (int) ans % mod;
    }

    private static int gcd(int B, int C) {
        if (C == 0) return B;
        return gcd(C, B % C);
    }

    public static void main(String[] args) {
        int A = 807414236;
        int B = 3788;
        int C = 38141;
        System.out.println(getMagicalNumber(A, B, C));
    }
}
