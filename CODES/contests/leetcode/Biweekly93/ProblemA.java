package contests.leetcode.Biweekly93;

public class ProblemA {

    public static boolean checkAlphabet(char alpha) {
        if ((alpha >= 65 && alpha <= 90) || (alpha >= 97 && alpha <= 122)) 
            return true;

        return false;
    }

    public static int maximumValue(String[] strs) {
        int count = 0, ans = 0;
        for (int i = 0; i < strs.length; i++) {
            String data = strs[i];
            for(int j = 0; j < data.length(); j++) {
                if(checkAlphabet(data.charAt(j))) {
                    count = data.length();
                    break;
                }
                count = count * 10 + (data.charAt(j) - '0');
            }
            ans = Math.max(ans, count);
            count = 0;
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] str = {"3glko","1"};
        System.out.println(maximumValue(str));
    }
}
