package binarysearch;

public class SingleElementInSortedArray {
    public static int singleElementInASortedArray(int[] nums) {
        int start = 0;
        int end = nums.length - 2;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            // if you are in left side then move to right
            if(nums[mid] == nums[mid ^ 1]) {
                start = mid + 1;
            }
            // if you are in right side then move to left
            else end = mid - 1;
        }

        return nums[start];
    }

    public static void main(String[] args) {
        int[] nums = {3,3,7,7,10,11,11};
        System.out.println(singleElementInASortedArray(nums));
    }
}
