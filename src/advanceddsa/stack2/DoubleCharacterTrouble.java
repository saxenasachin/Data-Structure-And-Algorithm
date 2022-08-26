package advanceddsa.stack2;

import java.util.Stack;

/**
 * Problem Description
 * You are given a string A.
 * <p>
 * An operation on the string is defined as follows:
 * <p>
 * Remove the first occurrence of the same consecutive characters. eg for a string "abbcd", the first occurrence of same consecutive characters is "bb".
 * <p>
 * Therefore the string after this operation will be "acd".
 * <p>
 * Keep performing this operation on the string until there are no more occurrences of the same consecutive characters and return the final string.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * First and only argument is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the final string.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = abccbc
 * Input 2:
 * <p>
 * A = ab
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "ac"
 * Output 2:
 * <p>
 * "ab"
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Remove the first occurrence of same consecutive characters. eg for a string "abbc",
 * the first occurrence of same consecutive characters is "bb".
 * Therefore, the string after this operation will be "ac".
 * Explanation 2:
 * <p>
 * No removals are to be done.
 */
public class DoubleCharacterTrouble {

    public static String solve(String A) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (Character ch : stack) {
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String A = "abccbc";
        System.out.println(solve(A));
    }
}
