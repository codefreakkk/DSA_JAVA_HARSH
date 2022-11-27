package Hashing;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static String customSortString(String order, String s) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(String.valueOf(s.charAt(i)))) {
                map.put(String.valueOf(s.charAt(i)), map.get(String.valueOf(s.charAt(i))) + 1);
            }
            else map.put(String.valueOf(s.charAt(i)), 1);
        }

        String answer = "";
        for(int i = 0; i < order.length(); i++) {
            if(map.containsKey(String.valueOf(order.charAt(i)))) {
                int count = map.get(String.valueOf(order.charAt(i)));
                while(count > 0) {
                    answer += String.valueOf(order.charAt(i));
                    count--;
                }
                map.put(String.valueOf(order.charAt(i)), 0);
                map.remove(String.valueOf(order.charAt(i)));
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            String key = entry.getKey();

            while(count > 0) {
                answer += key;
                count--;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        String order = "cba";
        String s = "abcdd";
        System.out.println(customSortString(order, s));
    }
}
