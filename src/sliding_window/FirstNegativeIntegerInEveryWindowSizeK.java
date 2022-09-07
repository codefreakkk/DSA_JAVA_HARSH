package sliding_window;

import java.util.*;

public class FirstNegativeIntegerInEveryWindowSizeK {
    public static long[] firstNegativeInteger(long[] nums, int n, int k) {
        int i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        while(j < n) {
            if(nums[j] < 0) list.add((int) nums[j]);
            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k) {
                if(list.isEmpty()) answer.add(0);
                else {
                    answer.add(list.get(0));
                    if (nums[i] == list.get(0)) list.remove(0);
                }
                i++;
                j++;
            }
        }

        long[] ans = answer.stream().mapToLong(Integer::longValue).toArray();
        return ans;
    }

    public static void main(String[] args) {
        long[] nums = {-8, 2, 3, -6, 10};
        int k = 2;
        long[] ans = firstNegativeInteger(nums, nums.length, k);
        System.out.println(Arrays.toString(ans));
    }
}
