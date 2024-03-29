package advanceddsa.stack2;

import java.util.Stack;

/**
 * Problem Description
 * Given string A denoting an infix expression. Convert the infix expression into a postfix expression.
 * <p>
 * String A consists of ^, /, *, +, -, (, ) and lowercase English alphabets where lowercase English alphabets are operands and ^, /, *, +, - are operators.
 * <p>
 * Find and return the postfix expression of A.
 * <p>
 * NOTE:
 * <p>
 * ^ has the highest precedence.
 * / and * have equal precedence but greater than + and -.
 * + and - have equal precedence and lowest precedence among given operators.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= length of the string <= 500000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string denoting the postfix conversion of A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "x^y/(a*z)+b"
 * Input 2:
 * <p>
 * A = "a+b*(c^d-e)^(f+g*h)-i"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "xy^az/b+"
 * Output 2:
 * <p>
 * "abcd^e-fgh*+^*+i-"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Output denotes the postfix expression of the given input.
 */
public class InfixToPostfix {

    public static String solve(String A) {
        Stack<Character> stack = new Stack<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            int priority = getPriority(ch);
            if (priority == -1) { // operand
                if (ch == '(') {
                    stack.push(ch);
                } else if (ch == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        stringBuilder.append(stack.pop());
                    }
                    stack.pop();
                } else {
                    stringBuilder.append(ch);
                }
            } else {
                // operator
                while (!stack.isEmpty() && getPriority(stack.peek()) >= priority) {
                    stringBuilder.append(stack.pop());
                }
                stack.push(ch);
            }
        }
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pop());
        }
        return stringBuilder.toString();
    }

    private static int getPriority(char ch) {
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static void main(String[] args) {
        String A = "x^y/(a*z)+b";
        System.out.println(solve(A));
    }
}
