package Hashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

//    this is bruteforce solution TC : o(N) + o(N), SC : o(N)
    public static int lengthOfLongestSubstring1(String s) {
        if(s.length() == 0) return 0;
        Set<String> set = new HashSet<>();
        int size = s.length();
        int maxi = Integer.MIN_VALUE;;
        int left = 0, right = 0;

        for(int i = 0; i < size; i++) {
            if(set.contains(String.valueOf(s.charAt(right)))) {
                while(set.contains(String.valueOf(s.charAt(right)))) {
                    set.remove(String.valueOf(s.charAt(left)));
                    left++;
                }
            }
            set.add(String.valueOf(s.charAt(right)));
            int windowSize = (right - left) + 1;
            maxi = Integer.max(maxi, windowSize);
            right++;
        }

        return maxi;
    }

//    optimised approach TC : o(N), SC : o(N)
    public static int lengthOfLongestSubstring(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        int size = s.length(), maxi = Integer.MIN_VALUE, len = 0, left = 0, right = 0;

        for(int i = 0; i < size; i++) {
            if(map.containsKey(String.valueOf(s.charAt(right))) && left <= map.get(String.valueOf(s.charAt(right)))) {
                left = map.get(String.valueOf(s.charAt(right))) + 1;
            }
            int windowSize = (right - left) + 1;
            maxi = Integer.max(maxi, windowSize);
            map.put(String.valueOf(s.charAt(right)), i);
            right++;
        }

        return maxi;
    }

    public static void main(String[] args) {
        String s = "bbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
