package advanceddsa.stack1;

import java.util.Stack;

/**
 * Problem Description
 * Given an expression string A, examine whether the pairs and the orders of “{“,”}”, ”(“,”)”, ”[“,”]” are correct in A.
 * <p>
 * Refer to the examples for more clarity.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first and the only argument of input contains the string A having the parenthesis sequence.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 0 if the parenthesis sequence is not balanced.
 * <p>
 * Return 1 if the parenthesis sequence is balanced.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = {([])}
 * Input 2:
 * <p>
 * A = (){
 * Input 3:
 * <p>
 * A = ()[]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * 1
 * Output 2:
 * <p>
 * 0
 * Output 3:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * You can clearly see that the first and third case contain valid paranthesis.
 * <p>
 * In the second case, there is no closing bracket for {, thus the paranthesis sequence is invalid.
 */
public class BalancedParenthesis {

    public static int solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            switch (ch) {
                case '{':
                case '[':
                case '(':
                    stack.push(ch);
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return 0;
                    }
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return 0;
                    }
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return 0;
                    }
                    break;
            }
        }
        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        String A = "()[";
        System.out.println(solve(A));
    }
}
