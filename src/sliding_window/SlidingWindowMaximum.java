package sliding_window;

import java.util.*;

public class SlidingWindowMaximum {
    public static int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0, size = nums.length;
        List<Integer> list = new ArrayList<>();
        List<Integer> ans = new ArrayList<>();

        while(j < size) {
            while(!list.isEmpty() && list.get(list.size() - 1) < nums[j]) {
                list.remove(list.size() - 1);
            }
            list.add(nums[j]);

            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k){
                ans.add(list.get(0));
                if(nums[i] == list.get(0)) list.remove(0);
                i++;
                j++;
            }
        }

        int[] answer = ans.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1, 4, 5, 2, 3, 6};
        int k = 3;
        int[] ans = maxSlidingWindow(nums, k);
        System.out.println(Arrays.toString(ans));
    }
}
