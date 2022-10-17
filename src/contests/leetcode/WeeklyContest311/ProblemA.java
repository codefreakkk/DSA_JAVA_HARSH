package contests.leetcode.WeeklyContest311;

public class ProblemA {
    public static int smallestEvenMultiple(int n) {
        int ans = -1;
        for(int i = 1; i <= 150 * 2; i++) {
            if(i % n == 0 && i % 2 == 0) {
                ans = i;
                return ans;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 149;
        System.out.println(smallestEvenMultiple(n));
    }
}
