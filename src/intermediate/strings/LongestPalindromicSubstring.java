package intermediate.strings;

/**
 * Problem Description
 * Given a string A of size N, find and return the longest palindromic substring in A.
 * <p>
 * Substring of string A is A[i...j] where 0 <= i <= j < len(A)
 * <p>
 * Palindrome string:
 * A string which reads the same backwards. More formally, A is palindrome if reverse(A) = A.
 * <p>
 * Incase of conflict, return the substring which occurs first ( with the least starting index).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 6000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is a string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string denoting the longest palindromic substring of string A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * A = "aaaabaaa"
 * <p>
 * <p>
 * Example Output
 * "aaabaaa"
 * <p>
 * <p>
 * Example Explanation
 * We can see that longest palindromic substring is of length 7 and the string is "aaabaaa".
 */
public class LongestPalindromicSubstring {

    public static String longestPalindrome(String A) {

        int n = A.length(); // length of string

        StringBuilder sb = new StringBuilder();
        // check for odd length string
        for (int i = 0; i < n; i++) {
            String s = pWithCenter(A, i, i);
            if (s.length() > sb.length()) {
                sb.setLength(0);
                sb.append(s);
            }
        }

        // check for even length
        for (int i = 0; i < n - 1; i++) {
            String s = pWithCenter(A, i, i + 1);
            if (s.length() > sb.length()) {
                sb.setLength(0);
                sb.append(s);
            }
        }

        return sb.toString();
    }

    /**
     * start from start and end as center and expand to both sides of string until we find palindrome.
     *
     * @param A     - original string
     * @param start - start which will move to left
     * @param end   - end which will move to right
     * @return - the longest palindrome string with (start, end) as center
     */
    private static String pWithCenter(String A, int start, int end) {
        while (start >= 0 && end < A.length() && A.charAt(start) == A.charAt(end)) {
            start--;
            end++;
        }
        return A.substring(start + 1, end);
    }

    public static void main(String[] args) {
        String A = "aaaabaaa";
        System.out.println(longestPalindrome(A));
    }
}
