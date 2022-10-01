package contests.leetcode.Biweekly88;

import java.util.*;

public class RemoveLetterToEqualizeFrequency {
    public static boolean equalFrequency(String word) {
        int[] map = new int[26];

        // store frequency in array
        for(char c : word.toCharArray()) {
            map[c - 'a']++;
        }

        for(int i = 0; i < 26; i++) {
            int[] f = map.clone();

            if(f[i] <= 0) continue;
            f[i]--;

            // add values in set
            Set<Integer> set = new HashSet<>();
            for(int x : f) {
                if(x > 0) set.add(x);
            }

            if(set.size() == 1) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        String word = "abccc";
        System.out.println(equalFrequency(word));
    }
}
