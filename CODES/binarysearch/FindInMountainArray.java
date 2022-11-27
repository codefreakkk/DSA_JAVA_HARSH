package binarysearch;

  interface MountainArray {
      public int get(int index);
      public int length();
 }
public class FindInMountainArray {

    public static int search(MountainArray nums, int start, int end, int target) {

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(nums.get(mid) == target) {
                return mid;
            }
            else if(nums.get(mid) < target) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }

        return -1;
    }

    public static int agnosticSearch(MountainArray nums, int start, int end, int target) {

        while(start <= end) {
            int mid = start + (end - start) / 2;

            if(target == nums.get(mid)) return mid;
            if(target > nums.get(mid)) {
                end = mid - 1;
            }
            else start = mid + 1;
        }

        return -1;
    }

    public static int getPeakElement(MountainArray nums) {
        int start = 0;
        int end = nums.length() - 1;

        while(start < end) {
            int mid = start + (end - start) / 2;

            if(nums.get(mid) > nums.get(mid + 1)) {
                end = mid;
            }
            else start = mid + 1;
        }

        return start;
    }

    public static int findInMountainArray(MountainArray nums, int target) {
        int peak = getPeakElement(nums);
        int left = search(nums, 0, peak, target);
        if(left != -1) return left;

        return agnosticSearch(nums, peak + 1, nums.length() - 1, target);
    }

    public static void main(String[] args) {

    }
}
