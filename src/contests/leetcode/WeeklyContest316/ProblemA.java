package contests.leetcode.WeeklyContest316;

// solved
public class ProblemA {
    public static boolean haveConflict(String[] event1, String[] event2) {
        // convert time into integer
        int start1 = Integer.parseInt(event1[0].substring(0, 2)) * 60 + Integer.parseInt(event1[0].substring(3));
        int end1 = Integer.parseInt(event1[1].substring(0, 2)) * 60 + Integer.parseInt(event1[1].substring(3));
        int start2 = Integer.parseInt(event2[0].substring(0, 2)) * 60 + Integer.parseInt(event2[0].substring(3));
        int end2 = Integer.parseInt(event2[1].substring(0, 2)) * 60 + Integer.parseInt(event2[1].substring(3));

        return start2 <= end1 && start1 <= end2;
    }

    public static void main(String[] args) {
        String[] e1 = {"01:15","02:00"};
        String[] e2 = {"02:00","03:00"};

        System.out.println(haveConflict(e1, e2));
    }
}
