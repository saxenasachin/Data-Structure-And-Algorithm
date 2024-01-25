package advanceddsa.dynamicprogramming;

/**
 * Problem Description
 * <p>
 * In Dance land, one person can party either alone or can pair up with another person.
 * <p>
 * Can you find out how many ways they can party if there are A people in Dance land?
 * <p>
 * Note: Return your answer modulo 10003, as the answer can be large.
 * <p>
 * <p>
 * <p>
 * Problem Constraints
 * <p>
 * 1 <= A <= 105
 * <p>
 * <p>
 * <p>
 * Input Format
 * <p>
 * Given only an argument of type Integer, number of people in Dance land.
 * <p>
 * <p>
 * <p>
 * Output Format
 * <p>
 * Return an integer denoting the number of ways people of Dance land can party.
 * <p>
 * <p>
 * <p>
 * Example Input
 * <p>
 * Input 1:
 * <p>
 * A = 3
 * Input 2:
 * <p>
 * A = 5
 * <p>
 * <p>
 * Example Output
 * <p>
 * Output 1:
 * <p>
 * 4
 * Output 2:
 * <p>
 * 26
 * <p>
 * <p>
 * Example Explanation
 * <p>
 * Explanation 1:
 * <p>
 * Let suppose three people are A, B, and C. There are only 4 ways to party
 * (A, B, C) All party alone
 * (AB, C) A and B party together and C party alone
 * (AC, B) A and C party together and B party alone
 * (BC, A) B and C party together and A
 * here 4 % 10003 = 4, so the answer is 4.
 * <p>
 * Explanation 2:
 * <p>
 * Number of ways they can party are: 26.
 */
public class LetsParty {

    public static int solve(int A) {

        // base conditions
        if (A == 0) return 0;
        if (A == 1) return 1;
        if (A == 2) return 2;

        // initialisation
        int[] dp = new int[A + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;

        // ways(n) = ways(n - 1) + (n - 1) * ways(n - 2)
        // 1 person can dance alone or pair with 1 other person,
        // if 1 persona pairs with 1 of the remaining (n - 1) person, possible ways of pairing is (n - 1) and for
        // remaining (n - 2) person, we need to find ways(n - 2). so total ways if a person pairs with another person
        // is (n - 1) * ways(n - 2)
        // if a person dances alone, then no of ways would be ways(n - 1) i.e. ways for remaining (n - 1) person.
        for (int i = 3; i <= A; i++) {
            dp[i] = (dp[i - 1] + (i - 1) * dp[i - 2]) % 10003;
        }
        return dp[A];
    }

    public static void main(String[] args) {
        int A = 5;
        System.out.println("Number of ways : " + solve(A));
    }
}
