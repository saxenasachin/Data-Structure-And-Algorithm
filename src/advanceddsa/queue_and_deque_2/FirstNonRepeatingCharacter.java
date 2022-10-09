package advanceddsa.queue_and_deque_2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Problem Description
 * Given a string A denoting a stream of lowercase alphabets, you have to make a new string B.
 * B is formed such that we have to find the first non-repeating character each time a character is inserted to the stream and append it at the end to B. If no non-repeating character is found, append '#' at the end of B.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is string A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return a string B after processing the stream of lowercase alphabets A.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = "abadbc"
 * Input 2:
 * <p>
 * A = "abcabc"
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * "aabbdd"
 * Output 2:
 * <p>
 * "aaabc#"
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "aba"    -   first non repeating character 'b'
 * "abad"   -   first non repeating character 'b'
 * "abadb"  -   first non repeating character 'd'
 * "abadbc" -   first non repeating character 'd'
 * Explanation 2:
 * <p>
 * "a"      -   first non repeating character 'a'
 * "ab"     -   first non repeating character 'a'
 * "abc"    -   first non repeating character 'a'
 * "abca"   -   first non repeating character 'b'
 * "abcab"  -   first non repeating character 'c'
 * "abcabc" -   no non repeating character so '#'
 */
public class FirstNonRepeatingCharacter {

    public static String solve(String A) {
        StringBuilder stringBuilder = new StringBuilder(); // holds the output string

        Queue<Character> queue = new LinkedList<>(); // holds the candidate list of characters, which could be in output
        int[] charFreq = new int[26]; // holds the frequency of characters as only lowercase letters will be in stream of input
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            int index = ch - 'a'; // relative index in array
            charFreq[index]++;

            if (charFreq[index] == 1) { // will be candidate
                queue.offer(ch);
            }

            // check from front of queue, remove can't be candidate anymore, i.e. frequency of that character is greater than 1.
            while (!queue.isEmpty()) {
                char front = queue.peek();
                int relativeIndex = front - 'a';
                if (charFreq[relativeIndex] > 1) {
                    queue.remove();
                } else {
                    break;
                }
            }

            // non repeating character will be at front of queue.
            if (!queue.isEmpty()) {
                stringBuilder.append(queue.peek());
            } else {
                stringBuilder.append("#");
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String A = "abcabc";
        System.out.println(solve(A));
    }
}
