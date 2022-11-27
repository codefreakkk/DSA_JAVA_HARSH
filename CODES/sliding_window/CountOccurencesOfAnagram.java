package sliding_window;

import java.util.Arrays;
import java.util.HashMap;

public class CountOccurencesOfAnagram {

    // this solution will give TLE partially correct
    public static String sortString(String str) {
        char[] data = str.toCharArray();
        Arrays.sort(data);
        String text = String.valueOf(data);
        return text;
    }

    public static int search1(String pat, String txt) {
        String temp = sortString(pat);
        int i = 0, j = 0, k = pat.length(), size = txt.length();
        int count = 0;

        while(j < size) {
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k){
                String text = sortString(txt.substring(i, j + 1));
                if(temp.equals(text)) count++;
                i++;
                j++;
            }
        }

        return count;
    }

    public static int search(String pat, String txt) {
        int k = pat.length();
        int i  = 0, j = 0, ans = 0;
        HashMap<String, Integer> map = new HashMap<>();

        for(int jj = 0; jj < k; jj++) {
            if(map.containsKey(String.valueOf(pat.charAt(jj)))) {
                map.put(String.valueOf(pat.charAt(jj)), map.get(String.valueOf(pat.charAt(jj))) + 1);
            }
            else map.put(String.valueOf(pat.charAt(jj)), 1);
        }

        int count = map.size();
        while(j < txt.length()) {
            String data = String.valueOf(txt.charAt(j));
            if(map.containsKey(data)) map.put(data, map.get(data) - 1);
            if(map.containsKey(data) && map.get(data) == 0) count--;

            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k) {
                if(count == 0) ans++;
                String first = String.valueOf(txt.charAt(i));
                if(map.containsKey(first)) {
                    map.put(first, map.get(first) + 1);

                    // if the transition is made from 0 to 1 than only increment the count
                    if(map.get(first) == 1) count++;
                }
                i++;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String pat = "for";
        String txt = "forxxorfxdofr";

        System.out.println(search(pat, txt));
    }

}
