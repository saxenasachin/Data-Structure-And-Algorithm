package advanceddsa.twopointers1;

/**
 * Problem Description
 * Given a sorted array of integers (not necessarily distinct) A and an integer B, find and return how many pair of integers ( A[i], A[j] ) such that i != j have sum equal to B.
 * <p>
 * Since the number of such pairs can be very large, return number of such pairs modulo (109 + 7).
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * 1 <= |A| <= 100000
 * <p>
 * 1 <= A[i] <= 10^9
 * <p>
 * 1 <= B <= 10^9
 * <p>
 * <p>
 * <p>
 * Input Format
 * The first argument given is the integer array A.
 * <p>
 * The second argument given is integer B.
 * <p>
 * <p>
 * <p>
 * Output Format
 * Return the number of pairs for which sum is equal to B modulo (10^9+7).
 * <p>
 * <p>
 * <p>
 * Example Input
 * Input 1:
 * <p>
 * A = [1, 1, 1]
 * B = 2
 * Input 2:
 * <p>
 * <p>
 * A = [1, 1]
 * B = 2
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 3
 * Output 2:
 * <p>
 * 1
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Any two pairs sum up to 2.
 * Explanation 2:
 * <p>
 * only pair (1, 2) sums up to 2.
 */
public class PairsWithGivenSumII {

    /**
     * 1. Start two pointers from beginning & end
     * 2. If (A[l] + A[r] == sum) then increment global "ans" variable
     * 3. To handle duplicates, count all duplicate values equal to A[r] and add it to global variable
     *
     * @param A - input array
     * @param B - sum
     * @return - count of pairs
     */
    public static int getCountOfPairs(int[] A, int B) {
        long mod = 1000000007;
        int i = 0, j = A.length-1;
        long countI = 1, countJ = 1;
        long ans = 0;

        while (i < j) {
            int I = A[i];
            int J = A[j];
            int sum = A[i] + A[j];
            if (sum == B) {
                while (i < A.length-1 && A[i] == A[i+1]) {
                    countI++;
                    i++;
                }
                while (j > 0 && A[j] == A[j-1]) {
                    countJ++;
                    j--;
                }
                if (I == J) {
                    long conI;
                    if (countI == 1 || countI == 2) {
                        conI = 1;
                    } else {
                        conI = ((countI * (countI-1) / 2) % mod);
                    }
                    ans = (ans + conI) % mod;
                } else {
                    long temp = (countI * countJ) % mod;
                    ans = (ans + temp) % mod;
                }
                i++;
                j--;
            } else if (sum < B) {
                i++;
                while (i < A.length && A[i] == A[i-1]) {
                    i++;
                }
            } else {
                j--;
                while (j > 0 && A[j] == A[j+1]) {
                    j--;
                }
            }
            countI = 1;
            countJ = 1;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[] A = { 2, 2, 3, 4, 4, 5, 6, 7, 10};
        int B = 8;
        System.out.println(getCountOfPairs(A, B));
    }
}
