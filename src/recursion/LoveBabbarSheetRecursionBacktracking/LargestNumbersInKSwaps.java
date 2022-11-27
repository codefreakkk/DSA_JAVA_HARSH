package recursion.LoveBabbarSheetRecursionBacktracking;

import java.util.Arrays;

//-----------------------problem not solved--------------------------

public class LargestNumbersInKSwaps {

    public static void solve(String s, int index, int k, String ans) {
        if(k == 0) return;

        // find max char from right
        char maxChar = s.charAt(index);
        for(int i = index + 1; i < s.length(); i++) {
            if(s.charAt(i) > maxChar) {
                maxChar = s.charAt(i);
            }
        }
        System.out.println(maxChar);
        if(maxChar != s.charAt(index)) k--;

        // swap k characters using recursion
        for(int i = s.length() - 1; i >= index; i--) {
            if(s.charAt(i) == maxChar) {
                char[] str1 = s.toCharArray();
                char temp1 = str1[index];
                str1[index] = str1[i];
                str1[i] = temp1;
                s = str1.toString();

                if(ans.compareTo(s) < 0) {
                    ans = s;
                }

                solve(s, index + 1, k, ans);

                char[] str = s.toCharArray();
                char temp = str[index];
                str[index] = str[i];
                str[i] = temp;
                s = str.toString();
            }
        }
    }

    public static String findMaximum(String str, int k) {
        String ans = "";
        solve(str, 0, k, ans);
        return ans;
    }

    public static void main(String[] args) {
        String s = "1234567";
        System.out.println(findMaximum(s, 4));
    }
}
