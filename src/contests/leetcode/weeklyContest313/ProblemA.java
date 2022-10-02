package contests.leetcode.weeklyContest313;

public class ProblemA {
    public static int commonFactors(int a, int b) {
        int count = 0;
        int max = Math.max(a, b);

        for(int i = 1; i <= max; i++) {
            if(a % i == 0 && b % i == 0) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        System.out.println(commonFactors(25, 30));
    }
}
