package contests.leetcode.Contest310;

import java.util.*;

public class ProblemB {
    public static int partitionString(String str) {
        // use hashing
        HashMap<Character, Integer> map = new HashMap<>();
        int size = str.length(), res = 1;

        for(int i = 0; i < size; i++) {
            if(map.containsKey(str.charAt(i)) && map.get(str.charAt(i)) > 0) {
                map.clear();
                res++;
            }

            map.put(str.charAt(i), map.getOrDefault(str.charAt(i), 0) + 1);
        }

        return res;
    }
    public static void main(String[] args) {
        String str = "ssss";
        System.out.println(partitionString(str));
    }
}
