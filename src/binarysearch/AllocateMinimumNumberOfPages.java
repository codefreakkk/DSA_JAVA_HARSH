package binarysearch;

import java.util.Arrays;

public class AllocateMinimumNumberOfPages {
    public static boolean canAllocateBooks(int[] nums, int mid, int m) {
        int students = 1;
        int pages = 0;

        for(int i = 0; i < nums.length; i++) {
            // if barrier (mid) < i'th element then no pages cannot be allocated
            if(nums[i] > mid) return false;

            if(pages + nums[i] > mid) {
                pages = nums[i];
                students++;
            }
            else pages += nums[i];
        }

        return students <= m;
    }

    public static int allocatePages(int[] nums, int m) {
        int start = nums[0];
        int end = Arrays.stream(nums).sum();
        int ans = -1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(canAllocateBooks(nums, mid, m)) {
                ans = mid;
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {12, 34, 67, 90};
        int students = 2;
        System.out.println(allocatePages(nums, students));
    }
}
