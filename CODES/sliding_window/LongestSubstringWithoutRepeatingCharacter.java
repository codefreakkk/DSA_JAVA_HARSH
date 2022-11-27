package sliding_window;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        int size = s.length();
        int maxi = Integer.MIN_VALUE, i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        while(j < size) {
            char key = s.charAt(j);
            if(map.containsKey(key)) map.put(key, map.get(key) + 1);
            else map.put(key, 1);

            if(map.size() == j - i + 1) maxi = Math.max(maxi, j - i + 1);
            if(map.size() < j - i + 1) {
                while(map.size() < j - i + 1) {
                    key = s.charAt(i);
                    map.put(key, map.get(key) - 1);
                    if(map.get(key) == 0) map.remove(key);
                    i++;
                }
            }
            j++;
        }

        return maxi;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
