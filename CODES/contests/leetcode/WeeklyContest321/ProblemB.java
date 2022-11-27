package contests.leetcode.WeeklyContest321;

public class ProblemB {
    public static int appendCharacters(String s, String t) {
        int i = 0, j = 0;

        while(i < s.length()) {
            if(s.charAt(i) == t.charAt(j)) j++;
            i++;
            if(j >= t.length()) return 0;
        }

        return t.length() - j;
    }

    public static void main(String[] args) {
        String s = "z";
        String t = "abcde";
        System.out.println(appendCharacters(s, t));
    }
}
