package contests.leetcode.WeeklyContest322;

import java.util.*;

public class ProblemB {

    public static long dividePlayers(int[] skills) {
        Arrays.sort(skills);
        int i = 0, j = skills.length - 1;
        long answer = 0;
        long sum = skills[i] + skills[j];

        while(i < j) {
            long temp = skills[i] + skills[j];
            if(sum != temp) return -1;
            answer += skills[i] * skills[j];
            sum = skills[i] + skills[j];
            i++;
            j--;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] skills = {1, 4, 5, 6, 2, 3};
        System.out.println(dividePlayers(skills));
    }
}
