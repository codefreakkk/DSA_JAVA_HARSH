package REVISION.recursion;

import java.util.*;

public class PhoneKeyPad {
    public static void solve(String digits, String unprocessed, int index, List<String> ans, HashMap<Character, String> map) {
        if(index >= digits.length()) {
            ans.add(unprocessed);
            return;
        }

        char ch = digits.charAt(index);
        for(int i = 0; i < map.get(ch).length(); i++) {
            char cur = digits.charAt(index);
            solve(digits, unprocessed + map.get(cur).charAt(i), index + 1, ans, map);
        }
    }

    public static List<String> letterCombination(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        // add phone number values in map
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        List<String> ans = new ArrayList<>();
        solve(digits, "", 0, ans, map);

        return ans;
    }

    public static void main(String[] args) {
        String s = "2";
        List<String> ans = letterCombination(s);
        System.out.println(ans);
    }
}
