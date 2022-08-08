package advanceddsa.stack1;

import java.util.Stack;

/**
 * Problem Description
 * Given a string A denoting an expression. It contains the following operators '+', '-', '*', '/'.
 * <p>
 * Check whether A has redundant braces or not.
 * <p>
 * NOTE: A will be always a valid expression and will not contain any white spaces.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return 1 if A has redundant braces else, return 0.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "((a+b))"
 * Input 2:
 * <p>
 * A = "(a+(a+b))"
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
 * Explanation 1:
 * <p>
 * ((a+b)) has redundant braces so answer will be 1.
 * Explanation 2:
 * <p>
 * (a+(a+b)) doesn't have have any redundant braces so answer will be 0.
 */
public class RedundantBraces {

    public static int braces(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            switch (ch) {
                case '(':
                case '+':
                case '-':
                case '*':
                case '/':
                    stack.push(ch);
                    break;
                case ')':
                    if (!stack.isEmpty()) {
                        Character peek = stack.peek();
                        if (peek == '+' || peek == '-' || peek == '*' || peek == '/') {
                            while (stack.peek() != '(') {
                                stack.pop();
                            }
                            stack.pop();
                        } else {
                            return 1;
                        }
                    }
                    break;

            }
        }
        return 0;
    }

    public static void main(String[] args) {
        String A = "a+b";
        System.out.println(braces(A));
    }
}
