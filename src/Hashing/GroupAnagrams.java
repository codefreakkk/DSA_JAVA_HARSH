package Hashing;

import java.util.*;

public class GroupAnagrams {
    public static String sortString(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);
        String answer = String.valueOf(arr);
        return answer;
    }

    public static List<List<String>> groupAnagrams(String[] str) {
        if(str.length == 0) {
            List<List<String>> ans = new ArrayList<>();
            return ans;
        }
        HashMap<String, List<String>> map = new HashMap<>();

        for(String s : str) {
            String temp = s;
            String sortedString = sortString(s);
            List<String> tempList = map.getOrDefault(sortedString, new ArrayList<>());
            tempList.add(temp);
            map.put(sortedString, tempList);
        }

        List<List<String>> answer = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry : map.entrySet()) {
            List<String> temp = entry.getValue();
            answer.add(temp);
        }

        return answer;
    }

    public static void main(String[] args) {
        String[] str = {"a"};
        List<List<String>> ans = groupAnagrams(str);

        for(List<String> s : ans) {
            System.out.println(s);
        }
    }
}
