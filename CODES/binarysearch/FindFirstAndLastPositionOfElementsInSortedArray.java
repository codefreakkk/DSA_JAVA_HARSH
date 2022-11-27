package binarysearch;

import java.util.Arrays;

public class FindFirstAndLastPositionOfElementsInSortedArray {
    public static int search(int[] nums, int target, boolean searchLeft) {
        int start = 0;
        int end = nums.length - 1;
        int possibleAns = -1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                possibleAns = mid;
                if(searchLeft) end = mid - 1;
                else start = mid + 1;
            }
            else if(target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return possibleAns;
    }

    public static int[] searchRange(int[] nums, int target) {
        int left = search(nums, target, true);
        int right = search(nums, target, false);

        return new int[]{left, right};
    }

    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int[] ans = searchRange(nums, 6);
        System.out.println(Arrays.toString(ans));
    }
}
