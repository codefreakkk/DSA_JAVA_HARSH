package REVISION.recursion;

public class RotatedBinarySearch {
    public static int solve(int[] nums, int target, int low, int high) {
        if(low > high) return -1;

        int mid = (low + high) / 2;

        if(nums[mid] == target) return mid;

        // if target is in left side
        if(nums[low] <= nums[mid]) {
            if(target >= nums[low] && target <= nums[mid]) {
                return solve(nums, target, low, mid - 1);
            }
            else return solve(nums, target, mid + 1, high);
        }
        // if target is in right side
        else if(target >= nums[mid] && target <= high) {
            return solve(nums, target, mid + 1, high);
        }
        // if target is nor in left or right
        else return solve(nums, target, low, mid - 1);

    }

    public static int search(int[] nums, int target) {
        return solve(nums, target, 0, nums.length - 1);
    }
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 19;

        System.out.println(search(nums, target));
    }
}
