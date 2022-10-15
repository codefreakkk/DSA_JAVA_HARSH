package contests.leetcode.biweekly89;

public class ProblemA {
    public static int countTime(String time) {
        int count = 1;
        if(time.charAt(0) == '?') {
            if(time.charAt(1) >= '4' && time.charAt(1) <= '9') count *= 2;
            else count *= 3;
        }

        if(time.charAt(1) == '?') {
            if(time.charAt(0) == '?') count = 24;
            else if(time.charAt(0) == '2') count *= 4;
            else count *= 10;
        }

        if(time.charAt(3) == '?') count *= 6;
        if(time.charAt(4) == '?') count *= 10;

        return count;
    }

    public static void main(String[] args) {
        String time = "?5:00";
        System.out.println(countTime(time));
    }
}
