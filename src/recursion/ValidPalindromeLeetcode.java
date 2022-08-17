package recursion;

public class ValidPalindromeLeetcode {
    public static boolean solve(String newstring, int left, int right) {
        if(left >= right) return true;
        if(newstring.charAt(left) != newstring.charAt(right)) return false;
        return solve(newstring, left + 1, right - 1);
    }

    public static boolean isPalindrome(String s) {
        char ch;
        String newstring = "";
        for(int i = 0; i < s.length(); i++) {
//            check if character is empty
            if (s.charAt(i) == ' ') continue;
//            check if character is letter or digit
            if (!Character.isLetterOrDigit(s.charAt(i))) continue;
            if (Character.isUpperCase(s.charAt(i))) {
                newstring += Character.toLowerCase(s.charAt(i));
                continue;
            }
            newstring += s.charAt(i);
        }
        return solve(newstring, 0, newstring.length() - 1);
    }

    public static void main(String[] args) {
        System.out.println(isPalindrome(" "));
    }
}
