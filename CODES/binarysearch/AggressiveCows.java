package binarysearch;

import java.util.Arrays;

public class AggressiveCows {
    public static boolean canPlaceCows(int[] nums, int mid, int m) {
        int cow = nums[0];
        int c = 1;

        for(int i = 1; i < nums.length; i++) {
            int dist = nums[i] - cow;
            if(dist >= mid) {
                cow = nums[i];
                c++;
            }
            if(c == m) return true;
        }

        return c == m;
    }

    public static int maxDistance(int[] nums, int m) {
        Arrays.sort(nums);

        int size = nums.length;

        int start = 0;
        int end = nums[size - 1] - nums[0];
        int ans = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(canPlaceCows(nums, mid, m)) {
                start = mid + 1;
                ans = mid;
            }
            else end = mid - 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 8, 9};
        int cow = 3;
        System.out.println(maxDistance(nums, cow));
    }
}
