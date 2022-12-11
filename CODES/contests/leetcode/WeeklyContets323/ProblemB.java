import java.util.*;

public class ProblemB {
    public static int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) 
            set.add(nums[i]);
        
        int ans = -1;
        for (int i = 0; i < nums.length; i++) {
            int count = 1, square = nums[i];
            while(true) {
                square *= square;
                if(set.contains(square)) 
                    count++;
                else 
                    break;
            }
            ans = Math.max(ans, count);
        }
        return ans == 1 ? -1 : ans;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,5,6,7};
        System.out.println(longestSquareStreak(nums));
    }
}
