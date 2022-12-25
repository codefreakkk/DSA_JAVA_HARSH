package contests.leetcode.WeeklyContest325;

// not completed
public class ProblemB {
    public static int takeCharacters(String s, int k) {
        int aCount = 0, bCount = 0, cCount = 0;
        int left = 0, right = s.length() - 1;

        while (aCount < k || bCount < k || cCount < k) {
            if (left == right)
                break;

            if (s.charAt(left) == 'a')
                aCount++;
            else if (s.charAt(left) == 'b')
                bCount++;
            else
                cCount++;
            left++;

            if (s.charAt(right) == 'a')
                aCount++;
            else if (s.charAt(right) == 'b')
                bCount++;
            else
                cCount++;
            right--;
        }
        System.out.println(right);
        return aCount + bCount + cCount;
    }

    public static void main(String[] args) {
        String s = "aabaaaacaabc";
        int k = 2;
        System.out.println(takeCharacters(s, k));
    }
}
