package REVISION.recursion;

public class BinarySearch {
    public static int solve(int[] nums, int n, int target, int low, int high) {
        if(low > high) return -1;

        int mid = (low + high) / 2;
            if(nums[mid] == target) return nums[mid];
            else if(nums[mid] < target) {
                return solve(nums, n, target, mid + 1, high);
            }
            else return solve(nums, n, target, low, mid - 1);
    }

    public static int binarySearch(int[] nums, int n, int k) {
        return solve(nums, n, k, 0, n - 1);
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(binarySearch(nums, nums.length, 90));

    }
}
