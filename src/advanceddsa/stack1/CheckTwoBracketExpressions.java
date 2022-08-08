package advanceddsa.stack1;

/**
 * Problem Description
 * Given two strings A and B. Each string represents an expression consisting of lowercase English alphabets, '+', '-', '(' and ')'.
 * <p>
 * The task is to compare them and check if they are similar. If they are identical, return 1 else, return 0.
 * <p>
 * NOTE: It may be assumed that there are at most 26 operands from ‘a’ to ‘z’, and every operand appears only once.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the each String <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * The given arguments are string A and string B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if they represent the same expression else return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "-(a+b+c)"
 * B = "-a-b-c"
 * Input 2:
 * <p>
 * A = "a-b-(c-d)"
 * B = "a-b-c-d"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * The expression "-(a+b+c)" can be written as "-a-b-c" which is equal as B.
 * Explanation 2:
 * <p>
 * Both the expression are different.
 */
public class CheckTwoBracketExpressions {

    public static int solve(String A, String B) {
        return 0;
    }

    public static void main(String[] args) {
        String A = "a-b-(c-d)";
        String B = "a-b-c-d";
        System.out.println(solve(A, B));
    }
}
