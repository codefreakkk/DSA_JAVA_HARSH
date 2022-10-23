package contests.leetcode.WeeklyContest316;

// not solved
public class ProblemA {
    public static boolean haveConflict(String[] event1, String[] event2) {
        String[] end1 = event1[1].split(":");
        String[] start2 = event2[0].split(":");

        int endTime1 = Integer.parseInt(end1[0]);
        int endTime2 = Integer.parseInt(start2[0]);

        if(endTime1 > 12 && endTime2 <= 12) return false;

        if(endTime2 <= endTime1) {
            if(endTime2 == endTime1) {
                if(Integer.parseInt(start2[1]) > Integer.parseInt(end1[1])) return false;
                else return true;
            }
            else return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String[] e1 = {"14:13","22:08"};
        String[] e2 = {"02:40","08:08"};

        System.out.println(haveConflict(e1, e2));
    }
}
