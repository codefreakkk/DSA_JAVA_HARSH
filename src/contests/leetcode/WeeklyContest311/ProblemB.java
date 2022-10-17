package contests.leetcode.WeeklyContest311;

public class ProblemB {
    public static int longestContinuousSubstring(String s) {
        int size = s.length();
        int i = 0, j = 1, max = 1;

        while(i < size && j < size) {
            if(s.charAt(j) - s.charAt(j - 1) == 1) {
                max = Math.max(j - i + 1, max);
                j++;
            }
            else {
                i = j;
                j++;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String s = "yrpjofyzubfsiypfre";
        System.out.println(longestContinuousSubstring(s));
    }
}
