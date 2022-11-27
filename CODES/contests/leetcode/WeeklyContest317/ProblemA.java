package contests.leetcode.WeeklyContest317;

public class ProblemA {
    public static int averageValue(int[] nums) {
        int size = nums.length;
        int ans = 0;
        int average = 0;

        for(int i = 0; i < size; i++) {
            if((nums[i] & 1) == 0) {
                if(nums[i] % 3 == 0) {
                    average++;
                    ans += nums[i];
                }
            }
        }

        if(ans == 0) return ans;
        return ans / average;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,4,7,10};
        System.out.println(averageValue(nums));
    }
}
