package contests.leetcode.WeeklyContest312;

import java.util.*;

public class ProblemA {
    public static String[] sortPeople(String[] names, int[] heights) {
        int size = heights.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        String[] ans = new String[size];

        for(int i = 0; i < size; i++) map.put(heights[i], i);

        Arrays.sort(heights);

        for(int i = 0, j = size - 1; i < size; i++, j--) {
            ans[i] = names[map.get(heights[j])];
        }

        return ans;
    }

    public static void main(String[] args) {
        String[] people = {"Mary","John","Emma"};
        int[] heights = {180,165,170};

        String[] ans = sortPeople(people, heights);
        System.out.println(Arrays.toString(ans));
    }
}
