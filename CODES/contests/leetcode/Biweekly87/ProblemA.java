package contests.leetcode.Biweekly87;

public class ProblemA {
    public static int convert(String time) {
        int[] months = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        String[] split = time.split("-");
        int month = Integer.parseInt(split[0]);
        int date = Integer.parseInt(split[1]);

        // count x dayss
        int cnt = 0;
        for(int i = 0; i < month; i++) {
            cnt += months[i];
        }
        cnt += date;
        return cnt;
    }
    public static int countDaysTogether(String a1, String d1, String a2, String d2) {
        int arrival1 = convert(a1);
        int arrival2 = convert(a2);
        int dep1 = convert(d1);
        int dep2 = convert(d2);

        int max = Math.max(arrival1, arrival2);
        int min = Math.min(dep1, dep2);

        if(max > min) return 0;
        return min - max + 1;
    }
    public static void main(String[] args) {
        System.out.println(countDaysTogether("08-15", "08-18", "08-16", "08-19"));
    }
}
