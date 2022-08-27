package advanceddsa.stack2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Stack;

/**
 * Problem Description
 * An arithmetic expression is given by a character array A of size N. Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * <p>
 * Valid operators are +, -, *, /. Each character may be an integer or an operator.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is character array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the value of arithmetic expression formed using reverse Polish Notation.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * A =   ["2", "1", "+", "3", "*"]
 * Input 2:
 * A = ["4", "13", "5", "/", "+"]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * 9
 * Output 2:
 * 6
 * <p>
 * <p>
 * Example Explanation
 * Explaination 1:
 * starting from backside:
 * * : () * ()
 * 3 : () * (3)
 * + : (() + ()) * (3)
 * 1 : (() + (1)) * (3)
 * 2 : ((2) + (1)) * (3)
 * ((2) + (1)) * (3) = 9
 * Explaination 2:
 * + : () + ()
 * / : () + (() / ())
 * 5 : () + (() / (5))
 * 13 : () + ((13) / (5))
 * 4 : (4) + ((13) / (5))
 * (4) + ((13) / (5)) = 6
 */
public class EvaluateExpression {

    public static int evalRPN(ArrayList<String> A) {
        Stack<String> stack = new Stack<>();
        for (String s : A) {
            if (Objects.equals(s, "+")) {
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1 + operand2));
            } else if (Objects.equals(s, "-")) {
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1 - operand2));
            } else if (Objects.equals(s, "*")) {
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1 * operand2));
            } else if (Objects.equals(s, "/")) {
                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(operand1 / operand2));
            } else {
                stack.push(s);
            }
        }
        return Integer.parseInt(stack.peek());
    }

    public static void main(String[] args) {
        String[] strings = {"4", "13", "5", "/", "+"};
        ArrayList<String> input = new ArrayList<>();
        Collections.addAll(input, strings);
        System.out.println(evalRPN(input));
    }
}
