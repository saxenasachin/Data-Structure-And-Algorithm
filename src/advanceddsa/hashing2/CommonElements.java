package advanceddsa.hashing2;

import java.util.*;

/**
 * Problem Description
 * Given two integer arrays, A and B of size N and M, respectively. Your task is to find all the common elements in both the array.
 * <p>
 * NOTE:
 * <p>
 * Each element in the result should appear as many times as it appears in both arrays.
 * The result can be in any order.
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= N, M <= 105
 * <p>
 * 1 <= A[i] <= 109
 * <p>
 * <p>
 * <p>
 * Input Format
 * First argument is an integer array A of size N.
 * <p>
 * Second argument is an integer array B of size M.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return an integer array denoting the common elements.
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 2, 2, 1]
 * B = [2, 3, 1, 2]
 * Input 2:
 * <p>
 * A = [2, 1, 4, 10]
 * B = [3, 6, 2, 10, 10]
 * <p>
 * <p>
 * Example Output
 * Output 1:
 * <p>
 * [1, 2, 2]
 * Output 2:
 * <p>
 * [2, 10]
 * <p>
 * <p>
 * Example Explanation
 * Explanation 1:
 * <p>
 * Elements (1, 2, 2) appears in both the array. Note 2 appears twice in both the array.
 * Explantion 2:
 * <p>
 * Elements (2, 10) appears in both the array.
 */
public class CommonElements {

    public static ArrayList<Integer> solve(List<Integer> A, List<Integer> B) {
        ArrayList<Integer> output = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        for (int b : B) {
            if (map.containsKey(b) && map.getOrDefault(b, 0) > 0) {
                output.add(b);
                map.put(b, map.getOrDefault(b, 0) - 1);
            }
        }
        return output;
    }

    public static void main(String[] args) {
        int[] A = {1, 2, 2, 1};
        int[] B = {2, 3, 1, 2};
        List<Integer> listA = Arrays.stream(A).boxed().toList();
        List<Integer> listB = Arrays.stream(B).boxed().toList();
        System.out.println(solve(listA, listB));
    }
}
