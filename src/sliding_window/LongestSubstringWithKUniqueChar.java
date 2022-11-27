package sliding_window;

import java.util.*;

public class LongestSubstringWithKUniqueChar {
    public static int longestSubstring(String s, int k) {
        int size = s.length();
        HashMap<String, Integer> map = new HashMap<>();
        int i = 0, j = 0, maxi = Integer.MIN_VALUE;

        while(j < size) {
            String element = String.valueOf(s.charAt(j));
            map.put(element, map.getOrDefault(element, 0) + 1);

            if(map.size() == k) {
                int index = j - i + 1;
                maxi = Math.max(maxi, index);
            }
            if(map.size() > k) {
                while(map.size() > k) {
                    String data = String.valueOf(s.charAt(i++));
                    map.put(data, map.get(data) - 1);
                    if(map.get(data) == 0) {
                        map.remove(data);
                    }
                }
            }
            j++;
        }

        if(maxi <= 0) return -1;
        return maxi;
    }

    public static void main(String[] args) {
        String s = "aabacbebebe";
        int k = 3;
        System.out.println(longestSubstring(s, k));
    }
}
