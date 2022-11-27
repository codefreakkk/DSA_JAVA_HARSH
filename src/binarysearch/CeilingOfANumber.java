package binarysearch;

public class CeilingOfANumber {
    public static int ceiling(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = (start + end) / 2;

            if(nums[mid] == target) {
                return mid;
            }
            else if(nums[mid] < target) {
                start = mid + 1;
            }
            else end = mid - 1;
        }

        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 9, 14, 16, 18};
        System.out.println(ceiling(nums, 4));
    }
}
