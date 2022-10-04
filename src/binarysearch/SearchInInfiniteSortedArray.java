package binarysearch;

public class SearchInInfiniteSortedArray {
    public static int search(int[] nums, int start, int end, int target) {
        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == nums[mid]) return mid;
            else if(target < nums[mid]) end = mid - 1;
            else start = mid + 1;
        }

        return -1;
    }

    // GFG method
    public static int searchInInfiniteSorted(int[] nums, int target) {
        int start = 0;
        int end = 1;

        while(nums[end] < target) {
            if(2 * end < nums.length - 1) end *= 2;
            else end = nums.length - 1;
        }
        return search(nums, start, end, target);
    }

    // kunal's method
    public static int searchInInfiniteSortedArray(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(nums[end] < target) {
            int newStart = start;
            end = end + (end - start + 1) * 2;
            start = newStart;
        }

        return search(nums, start, end, target);
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 7, 9, 10, 90, 100, 130, 140, 160, 170};
        int target = 3;
        System.out.println(searchInInfiniteSortedArray(nums, target));
    }
}
