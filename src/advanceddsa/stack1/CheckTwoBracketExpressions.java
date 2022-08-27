package advanceddsa.stack1;

import java.util.Stack;

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

    private static final int MAX_CHAR = 26; // as given in question, only lowercase letters

    public static int solve(String A, String B) {

        // evaluate string A
        boolean[] expressionA = evaluateExpression(A);
        boolean[] expressionB = evaluateExpression(B);
        // Now compare two array whether they are equal or not

        // initially consider both are equal
        int ans = 1; // true
        for (int i = 0; i < MAX_CHAR; i++) {
            if (expressionA[i] != expressionB[i]) {
                ans = 0;
                break;
            }
        }

        return ans;
    }

    private static boolean[] evaluateExpression(String s) {
        // stack containing global sign in an expression, as '(' comes, global sign changes based on sign before '('.
        // if ')' comes, we pops up stack to change global sign.
        // stack keeps current global sign at top of stack
        // '+' => true and '-' => false
        Stack<Boolean> globalSignStack = new Stack<>();

        boolean[] v = new boolean[MAX_CHAR]; // will contain sign of every character in strin as (+1 or -1)

        // global sign is positive initially
        globalSignStack.push(true);

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            switch (ch) {
                case '+':
                case '-':
                    break;
                case '(': {
                    boolean adjSign = adjacentSign(s, i);
                    if (adjSign) { // '+'
                        globalSignStack.push(true);
                    } else { // '-'
                        globalSignStack.push(!globalSignStack.peek());
                    }
                    break;
                }
                case ')':
                    globalSignStack.pop();
                    break;
                default: { // normal lowercase characters
                    boolean adjSign = adjacentSign(s, i);
                    if (!adjSign) { // if local sign negative, final sign will be !global sign
                        v[ch - 'a'] = !globalSignStack.peek();
                    } else { // if local sign positive, final sign will be same as global sign
                        v[ch - 'a'] = globalSignStack.peek();
                    }
                    break;
                }
            }
        }
        return v;
    }

    private static boolean adjacentSign(String s, int i) {
        if (i == 0) return true; // '+' sign
        // for '-' sign, return false otherwise return true.
        char ch = s.charAt(i - 1);
        return ch != '-';
    }

    public static void main(String[] args) {
        String A = "a-b-(c+d)";
        String B = "a-b-c-d";
        System.out.println(solve(A, B));
    }
}
