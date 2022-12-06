package recursion;

public class CheckPalindrome {

    public static boolean solve(int start, int end, String str) {
        if(start >= end) {
            return true;
        }
        if(str.charAt(start) != str.charAt(end)) {
            return false;
        }
        return solve(start + 1, end - 1, str);
    }

    public static boolean checkPalindrome(String str) {

        // WRITE YOUR CODE HERE
        return solve(0, str.length() - 1, str);

    }

    public static void main(String[] args) {
        System.out.println(checkPalindrome("aba"));
    }
}

