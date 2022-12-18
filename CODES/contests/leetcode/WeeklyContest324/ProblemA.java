package contests.leetcode.WeeklyContest324;

import java.util.*;

public class ProblemA {
    public static String sort(String word) {
        char[] array = word.toCharArray();
        Arrays.sort(array);
        return new String(array);
    }

    public static String removeDuplicates(String word) {
        String finalString = "";
        for (int j = 0; j < word.length(); j++) {
            if (j > 0 && word.charAt(j) == word.charAt(j - 1))   
                continue;
            else 
                finalString += word.charAt(j);
        }
        return finalString;
    }

    public static String getFinalString(String word) {
        String sorted = sort(word);
        String finalString = removeDuplicates(sorted);
        return finalString;
    }

    public static int similarPairs(String[] words) {
        int count = 0;
        for (int i = 0; i < words.length - 1; i++) {
            String target = getFinalString(words[i]);
            for (int j = i + 1; j < words.length; j++) {
                String finalString = getFinalString(words[j]);
                if (target.equals(finalString))
                    count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        String[] words = {"nba","cba","dba"};
        System.out.println(similarPairs(words));   
    }
}
