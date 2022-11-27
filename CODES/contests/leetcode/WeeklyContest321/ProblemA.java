package contests.leetcode.WeeklyContest321;

import java.util.*;

public class ProblemA {
    public static int pivotInteger(int n) {
        if(n == 1) return n;
        HashMap<Integer, Integer> map = new HashMap<>();
        int sum = 0;

        for(int i = 1; i <= n; i++) {
           sum += i;
           map.put(i, sum);
        }

        int lastValue = map.get(n);
        for(int i = 1; i <= n; i++) {
            int currentValue = map.get(i);
            int previousValue = map.getOrDefault(i - 1, 0);
            if(currentValue == (lastValue - previousValue)) return i;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(pivotInteger(1));
    }
}
