package binarysearch;


public class SearchInRotatedSortedArray2 {
    public static int getPivot(int[] nums) {
        int start = 0;
        int end = nums.length - 1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            // base condition for getting answer
            if(mid < end && nums[mid] > nums[mid + 1]) return mid;
            if(mid > start && nums[mid] < nums[mid - 1]) return mid - 1;

            if(nums[mid] == nums[start] && nums[mid] == nums[end]) {
                if(nums[start] > nums[start + 1]) return start;
                start++;

                if(nums[end] < nums[end - 1]) return end - 1;
                end--;
            }
            else if(nums[start] <= nums[mid] && nums[mid] > nums[end]) {
                start = mid + 1;
            }
            else end = mid - 1;
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

    public static boolean search(int[] nums, int target) {
        int pivot = getPivot(nums);
        int left = binarySearch(nums, target, 0, pivot);
        int right = binarySearch(nums, target, pivot + 1, nums.length - 1);

        if(left != -1 || right != -1) return true;
        return false;
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 3;
        System.out.println(search(nums, target));
    }
}
