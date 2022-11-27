package sliding_window;

import java.util.*;

public class MinimumWindowSubstring {

//    this thing can be applied while reducing i pointer
//     if(maxLen > end - start + 1) {
//        maxLen =  end - start + 1;
//        maxStart = start;
//        maxEnd = end + 1;
//    }

    public static String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        String answer = s;
        boolean flag = true;
        if(n < m) return "";
        int i = 0, j = 0;
        HashMap<Character, Integer> map = new HashMap<>();

        for(int ii = 0; ii < m; ii++) {
            map.put(t.charAt(ii), map.getOrDefault(t.charAt(ii), 0) + 1);
        }

        int count = map.size();
        while(j < n) {
            if(map.containsKey(s.charAt(j))) {
                map.put(s.charAt(j), map.get(s.charAt(j)) - 1);
                if(map.get(s.charAt(j)) == 0) count--;
            }
            if(count == 0) {
                flag = false;
                while(count == 0) {
                    String newString = s.substring(i, j + 1);
                    if(answer.length() > newString.length()) answer = newString;
                    if(map.containsKey(s.charAt(i))) {
                        map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
                        if(map.get(s.charAt(i)) == 1) count++;
                    }
                    i++;
                }
            }
            j++;
        }

        if(flag) return "";
        else return answer;
    }

    public static void main(String[] args) {
        String s = "a";
        String t = "b";
        System.out.println(minWindow(s, t));
    }
}
