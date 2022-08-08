package advanceddsa.stack1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Problem Description
 * You are given a matrix A of size N x 2 which represents different operations.
 * Assume initially you have a stack-like data structure you have to perform operations on it.
 * <p>
 * Operations are of two types:
 * <p>
 * 1 x: push an integer x onto the stack and return -1.
 * <p>
 * 2 0: remove and return the most frequent element in the stack.
 * <p>
 * If there is a tie for the most frequent element, the element closest to the top of the stack is removed and returned.
 * <p>
 * A[i][0] describes the type of operation to be performed. A[i][1] describe the element x or 0 corresponding to the operation performed.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N <= 100000
 * <p>
 * 1 <= A[i][0] <= 2
 * <p>
 * 0 <= A[i][1] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * The only argument given is the integer array A.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the array of integers denoting the answer to each operation.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [
 * [1, 5]
 * [1, 7]
 * [1, 5]
 * [1, 7]
 * [1, 4]
 * [1, 5]
 * [2, 0]
 * [2, 0]
 * [2, 0]
 * [2, 0]  ]
 * Input 2:
 * <p>
 * A =  [
 * [1, 5]
 * [2, 0]
 * [1, 4]   ]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [-1, -1, -1, -1, -1, -1, 5, 7, 5, 4]
 * Output 2:
 * <p>
 * [-1, 5, -1]
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Just simulate given operations.
 * Explanation 2:
 * <p>
 * Just simulate given operations.
 */
public class MaximumFrequencyStack {

    public static ArrayList<Integer> solve(ArrayList<ArrayList<Integer>> A) {

        Stack<Node> stack = new Stack<>();
        Stack<Node> temp = new Stack<>();

        ArrayList<Integer> output = new ArrayList<>();
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (ArrayList<Integer> integers : A) {
            int operation = integers.get(0);
            int value = integers.get(1);
            if (operation == 1) { // push
                int freq = freqMap.getOrDefault(value, 0) + 1;
                Node node = new Node(value, freq);
                if (stack.isEmpty()) {
                    stack.push(node);
                } else {
                    while (stack.peek().getFreq() > freq) {
                        temp.push(stack.pop());
                    }
                    stack.push(node);
                    while (!temp.isEmpty()) {
                        stack.push(temp.pop());
                    }
                }
                freqMap.put(value, freq);
                output.add(-1);
            } else if (operation == 2) {
                Node top = stack.pop();
                int freq = freqMap.getOrDefault(top.getValue(), 0);
                if (freq <= 1) {
                    freqMap.remove(top.getValue());
                } else {
                    freqMap.put(top.getValue(), freq - 1);
                }
                output.add(top.getValue());
            }
        }
        return output;
    }

    static class Node {
        private final int value;
        private final int freq;

        Node(int value, int freq) {
            this.value = value;
            this.freq = freq;
        }

        public int getValue() {
            return value;
        }

        public int getFreq() {
            return freq;
        }
    }

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> input = new ArrayList<>();

        ArrayList<Integer> testCase1 = new ArrayList<>();
        testCase1.add(1);
        testCase1.add(5);
        input.add(testCase1);

        ArrayList<Integer> testCase2 = new ArrayList<>();
        testCase2.add(1);
        testCase2.add(7);
        input.add(testCase2);

        ArrayList<Integer> testCase3 = new ArrayList<>();
        testCase3.add(1);
        testCase3.add(5);
        input.add(testCase3);

        ArrayList<Integer> testCase4 = new ArrayList<>();
        testCase4.add(1);
        testCase4.add(7);
        input.add(testCase4);

        ArrayList<Integer> testCase5 = new ArrayList<>();
        testCase5.add(1);
        testCase5.add(4);
        input.add(testCase5);

        ArrayList<Integer> testCase6 = new ArrayList<>();
        testCase6.add(1);
        testCase6.add(5);
        input.add(testCase6);

        ArrayList<Integer> testCase7 = new ArrayList<>();
        testCase7.add(2);
        testCase7.add(0);
        input.add(testCase7);
        input.add(testCase7);
        input.add(testCase7);
        input.add(testCase7);

        System.out.println(solve(input));
    }
}
