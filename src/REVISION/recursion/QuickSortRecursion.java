package REVISION.recursion;

import java.util.Arrays;

public class QuickSortRecursion {

    public static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];

        // find element which are smaller than
        int cnt = 0;
        for(int i = low + 1; i <= high; i++) {
            if(nums[i] <= pivot) {
                cnt++;
            }
        }

        // place pivot at right position
        int pivotIndex = low + cnt;
        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[low];
        nums[low] = temp;

        // check for smaller variable than pivot on left side and greater on right side
        int i= low, j = high;
        while(i < pivotIndex && j > pivotIndex) {
            while(nums[i] <= pivot) i++;
            while(nums[j] > pivot) j--;
            if(i < pivotIndex && j > pivotIndex) {
                int tempValue = nums[i];
                nums[i] = nums[j];
                nums[j] = tempValue;
                i++;
                j--;
            }

        }

        return pivotIndex;
    }
    public static void quick(int[] nums, int low, int high) {
        if(low >= high) return;

        int p = partition(nums, low, high);
        quick(nums, low, p - 1);
        quick(nums, p + 1, high);
    }

    public static void quickSort(int[] nums) {
        quick(nums, 0, nums.length - 1);
    }

    public static void main(String[] args) {
        int[] nums = {5, 4, 3, 2, 1, -1, -2, -3, -4};
        quickSort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
