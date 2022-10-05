package binarysearch;

public class FindRotationCountInSortedArray {
    public static int findKRotation(int[] nums) {
        if(nums.length == 1) return 0;
        int start = 0;
        int end = nums.length - 1;

        // base condition
        if(nums[0] < nums[end]) return 0;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(mid < end && nums[mid] > nums[mid + 1]) return mid + 1;
            else if(mid > start && nums[mid] < nums[mid - 1]) return mid;

                // if you are in right side
            else if(nums[0] < nums[mid]) start = mid + 1;
                // if you are in left side
            else if(nums[0] > nums[mid]) end = mid - 1;
        }

        return 0;
    }

    public static void main(String[] args) {
        int[] nums = {5, 1, 2, 3, 4};
        System.out.println(findKRotation(nums));
    }
}
