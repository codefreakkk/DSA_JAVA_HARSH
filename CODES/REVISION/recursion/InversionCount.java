package REVISION.recursion;

public class InversionCount {
    public static long merge(long[] nums, int start, int mid, int end) {
        int i = start, j = mid + 1;

        long[] temp = new long[end - start + 1];
        int k = 0, swap = 0;

        while(i <= mid && j <= end) {
            if(nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            }
            else {
                temp[k++] = nums[j++];
                swap += (mid + 1) - i;
            }
        }

        while(i <= mid) nums[k++] = nums[i++];
        while(j <= end) nums[k++] = nums[j++];

        // set array elements to their positions
        for(int l = 0, m = start; l < temp.length; l++, m++) {
            nums[m] = temp[l];
        }

        return swap;
    }
    public static long mergeSort(long[] nums, int start, int end) {
        long count = 0;
        if(start < end) {
            int mid = (start + end) / 2;

            count += mergeSort(nums, start, mid);
            count += mergeSort(nums, mid + 1, end);
            count += merge(nums, start, mid, end);
        }
        return count;
    }
    public static long inversionCount(long[] nums, long n) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        long[] nums = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(nums, nums.length));
    }
}
