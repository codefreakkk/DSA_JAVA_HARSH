package REVISION.recursion;

import java.util.*;

public class SubSequenceString {
    public static void solve(String ans, String s, List<String> list) {
        if(s.isEmpty()) {
            list.add(ans);
            return;
        }

        char ch = s.charAt(0);
        solve(ans + ch, s.substring(1), list);
        solve(ans, s.substring(1), list);
    }

    public static List<String> subSequence(String s) {
        List<String> list = new ArrayList<>();
        solve("", s, list);
        return list;
    }

    // subsequence iterative
    public static List<List<Integer>> subSequenceIterative(int[] nums) {
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());

        for(int val : nums) {
            int n = outerList.size();
            for(int i = 0; i < n; i++) {
                List<Integer> innerList = new ArrayList<>(outerList.get(i));
                innerList.add(val);
                outerList.add(innerList);
            }
        }

        return outerList;
    }

    public static void main(String[] args) {
//        String ans = "abc";
//        List<String> answer = subSequence(ans);
//        System.out.println(answer);

        int[] nums  ={1, 2 ,3};
        List<List<Integer>> ans = subSequenceIterative(nums);
        for(List<Integer> as : ans) {
            System.out.println(as);
        }
    }
}
