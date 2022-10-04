package binarysearch;

public class PeakIndexInMountainArray {
    public static int peakIndexInMountainArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(mid < nums.length - 1 && nums[mid] > nums[mid + 1]) {
                end = mid;
            }
            else start = mid + 1;
        }

        return start;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 5, 7, 6, 3, 2};
        System.out.println(peakIndexInMountainArray(nums));
    }
}
