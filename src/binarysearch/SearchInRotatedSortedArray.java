package binarysearch;

import static java.util.Arrays.binarySearch;

public class SearchInRotatedSortedArray {

    // using recursion
    public static int solve(int[] nums, int start, int end, int target) {
        if(start > end) return -1;

        int mid = start + (end - start) / 2;
        if(nums[mid] == target) return mid;

        // check if answer lies in left halve or not
        if(nums[start] <= nums[mid]) {
            if(target >= nums[start] && target <= nums[mid]) {
                return solve(nums, start, mid - 1, target);
            }
            else return solve(nums, mid + 1, end, target);
        }
        else if(target >= nums[mid] && target <= nums[end]) {
            return solve(nums, mid + 1, end, target);
        }
        return solve(nums, start, mid - 1, target);
    }

    // using recursion
    public static int search1(int[] nums, int target) {
        return solve(nums, 0, nums.length -1, target);
    }


    // using iteration
    public static int getPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            // base condition for getting answer
            if(mid < end && nums[mid] > nums[mid + 1]) return mid;
            if(mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

            if(nums[0] > nums[mid]) end = mid - 1;
            else if(nums[0] < nums[mid]) start = mid + 1;
        }

        return -1;
    }

    public static int binarySearch(int[] nums, int target, int low, int high) {

        while (low <= high)
        {
            int mid = (low + high) / 2;
            if (target < nums[mid])
            {
                high = mid - 1;
            }
            else if (target > nums[mid])
            {
                low = mid + 1;
            }
            else
            {
                return mid;
            }
        }
        return -1;
    }

    public static int search(int[] nums, int target) {
        int pivot = getPivot(nums);
        int left = binarySearch(nums, target, 0, pivot);

        if(left != -1) return left;
        return binarySearch(nums, target, pivot + 1, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 0};
        int target = 1;
        System.out.println(search(nums, target));
    }
}
