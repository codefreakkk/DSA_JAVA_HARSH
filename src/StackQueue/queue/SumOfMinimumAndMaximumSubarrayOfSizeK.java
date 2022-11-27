package StackQueue.queue;

import java.util.*;

public class SumOfMinimumAndMaximumSubarrayOfSizeK {
    public static int getSumOfMinAndMax(int[] nums, int k) {
        Deque<Integer> min = new LinkedList<>();
        Deque<Integer> max = new LinkedList<>();

        int ans = 0, size = nums.length;
        int i = 0, j = 0;

        while(j < size) {
            // check and add min element
            while(!min.isEmpty() && min.getFirst() >= nums[j]) min.removeFirst();
            min.addLast(nums[j]);

            // check and add max element
            while(!max.isEmpty() && max.getFirst() <= nums[j]) max.removeFirst();
            max.addLast(nums[j]);

            if(j - i + 1 < k) j++;

            else if(j - i + 1 == k) {
                ans += min.getFirst() + max.getFirst();

                if(min.getFirst() == nums[i]) min.removeFirst();
                else {
                    if(max.getFirst() == nums[i]) max.removeFirst();
                }

                i++;
                j++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {2, 5, -1, 4, -2, -1, -2};
        int k = 4;
        System.out.println(getSumOfMinAndMax(nums, k));
    }
}
