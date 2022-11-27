package REVISION.recursion;

public class ReversePair {
    public static int merge(int[] nums, int start, int mid, int end) {
        // count the inversions
        int index1 = start, index2 = mid + 1;
        int count = 0;

        for(int i = index1; i <= mid; i++) {
            while(index2 <= end && nums[i] > (2 * (long) nums[index2])) index2++;
            count += (index2 - (mid + 1));
        }

        index2 = mid + 1;
        index1 = start;
        int[] mix = new int[end - start + 1];
        int k = 0;

        while(index1 <= mid && index2 <= end) {
            if(nums[index1] <= nums[index2]) mix[k++] = nums[index1++];
            else mix[k++] = nums[index2++];
        }

        while(index1 <= mid) mix[k++] = nums[index1++];
        while(index2 <= end) mix[k++] = nums[index2++];

        for(int i = 0, j = start; i < mix.length; i++, j++) {
            nums[j] = mix[i];
        }

        return count;
    }
    public static int mergeSort(int[] nums, int start, int end) {
        if(start >= end)  return 0;

        int mid = (start + end) / 2;
        int inv = mergeSort(nums, start, mid);
        inv += mergeSort(nums, mid + 1, end);
        inv += merge(nums, start, mid, end);

        return inv;
    }

    public static int reversePair(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {2,4,3,5,1};
        System.out.println(reversePair(nums));
    }
}
