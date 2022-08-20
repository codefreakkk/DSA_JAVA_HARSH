package contests.leetcode;

public class ProblemA {
    public static int minimumRecolors(String blocks, int k) {
        int n = blocks.length();
        int min = k;
        for(int i = 0; i <= n - k; i++) {
            String ans = blocks.substring(i, i + k);
            int count = 0;
            for(char ch : ans.toCharArray()) {
                if(ch == 'W') count++;
            }
            min = Math.min(min, count);
        }
        return min;
    }

    public static void main(String[] args) {
        String blocks = "WBWBBW";
        int k = 2;
        System.out.println(minimumRecolors(blocks, k));
    }
}
