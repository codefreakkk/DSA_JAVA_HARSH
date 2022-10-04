package binarysearch;

public class OrderAgnosticBinarySearch {
    public static int orderAgnosticBinarySearch(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1};
        System.out.println(orderAgnosticBinarySearch(nums, 3));
    }
}
