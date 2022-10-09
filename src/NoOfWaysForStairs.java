public class NoOfWaysForStairs {

    private static int getNoOfWays(int num, int initialStep) {
        if (num == 0) return 0;
        if (initialStep > num) return  0;
        if (initialStep == num) return 1;
        return getNoOfWays(num, initialStep + 1) + getNoOfWays(num, initialStep + 2);
    }

    public static void main(String[] args) {
        System.out.println(getNoOfWays(45, 0));
    }
}
