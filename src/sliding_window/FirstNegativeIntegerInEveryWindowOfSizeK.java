package sliding_window;

import java.util.*;

public class FirstNegativeIntegerInEveryWindowOfSizeK {
    public static long[] firstNegativeInteger(long[] nums, int n, int k) {

        Deque<Integer> deque = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();

        int i = 0, j = 0;

        while(j < n) {
            if(nums[j] < 0) deque.addLast((int) nums[j]);

            if(j - i + 1 < k) j++;
            else if(j - i + 1 == k) {
                if(deque.isEmpty()) ans.add(0);
                else {
                    ans.add(deque.peek());
                    if(nums[i] == deque.peek())  {
                        deque.removeFirst();
                    }
                }
                i++;
                j++;
            }
        }

        long[] answer = ans.stream().mapToLong(l->l).toArray();
        return answer;
    }

    public static void main(String[] args) {
        long[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        long[] ans = firstNegativeInteger(nums, nums.length, k);
        System.out.println(Arrays.toString(ans));
    }
}
