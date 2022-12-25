package contests.leetcode.WeeklyContest325;

public class ProblemA {

    public static int closestTarget(String[] words, String target, int startIndex) {
        int leftCount = 0, i = startIndex;
        int n = words.length;
        boolean flag1 = false;

        // traverse left
        do {
            if (words[i].equals(target)) {
                flag1 = true;
                break;
            }
            leftCount++;
            i = (i - 1 + n) % n;
        } while (i != startIndex);

        // traverse right
        int rightCount = 0;
        boolean flag2 = false;
        i = startIndex;
        do {
            if (words[i].equals(target)) {
                flag2 = true;
                break;
            }
            rightCount++;
            i = (i + 1) % n;
        } while (i != startIndex);

        if (!flag1 && !flag2)
            return -1;

        return leftCount < rightCount ? leftCount : rightCount;
    }

    public static void main(String[] args) {
        String[] words = { "hello", "i", "am", "leetcode", "hello" };
        String target = "hello";
        int startIndex = 1;

        System.out.println(closestTarget(words, target, startIndex));
    }
}
