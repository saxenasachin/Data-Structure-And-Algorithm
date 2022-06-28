package advanceddsa.hashing2;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem Description
 * <p>
 * Given a string B, find if it is possible to re-order the characters of the string B so that it can be represented as a concatenation of A similar strings.
 * <p>
 * Eg: B = aabb and A = 2, then it is possible to re-arrange the string as "abab" which is a concatenation of 2 similar strings "ab".
 * <p>
 * If it is possible, return 1, else return -1.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= Length of string B <= 1000
 * <p>
 * 1 <= A <= 1000
 * <p>
 * All the alphabets of S are lower case (a - z)
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * First argument is an integer A.
 * Second argument is a string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Your function should return 1 if it is possible to re-arrange the characters of the string B so that it can be represented as a concatenation of A similar strings. If it is not, return -1.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 2
 * B = "bbaabb"
 * Input 2:
 * <p>
 * A = 1
 * B = "bc"
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * We can re-order the given string into "abbabb".
 * Explanation 2:
 * <p>
 * String "bc" is already arranged.
 */
public class ReplicatingSubstring {

    public static int solve(int A, String B) {
        int ans = 1;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0 ; i < B.length(); i++) {
            map.put(B.charAt(i), map.getOrDefault(B.charAt(i), 0) + 1);
        }
        for (int i = 0; i < B.length(); i++) {
            int count = map.getOrDefault(B.charAt(i), 0);
            if (count % A != 0) {
                ans = -1;
                break;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int A = 2;
        String B = "bbaabb";
        System.out.println(solve(A, B));
    }
}
