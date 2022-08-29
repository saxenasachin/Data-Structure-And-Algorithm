package advanceddsa.queue1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Problem Description
 * Given an integer A, you have to find the Ath Perfect Number.
 * <p>
 * A Perfect Number has the following properties:
 * <p>
 * It comprises only 1 and 2.
 * <p>
 * The number of digits in a Perfect number is even.
 * <p>
 * It is a palindrome number.
 * <p>
 * For example, 11, 22, 112211 are Perfect numbers, where 123, 121, 782, 1 are not.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= A <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is an integer A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string that denotes the Ath Perfect Number.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 2
 * Input 2:
 * <p>
 * A = 3
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 22
 * Output 2:
 * <p>
 * 1111
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 * Explanation 2:
 * <p>
 * First four perfect numbers are:
 * 1. 11
 * 2. 22
 * 3. 1111
 * 4. 1221
 */
public class PerfectNumbers {

    public static String solve(int A) {
        List<String> seriesList = new ArrayList<>(); // holds the series of numbers
        Queue<String> queue = new LinkedList<>(); // used to generate all the numbers
        queue.offer("1"); // given in question
        queue.offer("2"); // given in question

        // take out a number from front of queue, add it in series list by appending it with reverse of itself
        // append '1' and '2' with this front value taken out from queue, and again push in the queue.
        while (!queue.isEmpty()) {
            String valueAtFront = queue.remove();

            StringBuilder firstNumber = new StringBuilder(valueAtFront);
            seriesList.add(firstNumber.toString() + firstNumber.reverse());

            queue.add(valueAtFront + "1");
            queue.add(valueAtFront + "2");

            if (seriesList.size() >= A) {
                break;
            }
        }
        return seriesList.get(A - 1);
    }

    public static void main(String[] args) {
        int A = 4;
        System.out.println(solve(A));
    }
}
