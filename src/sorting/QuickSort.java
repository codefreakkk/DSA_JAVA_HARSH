package sorting;

import java.util.Arrays;

public class QuickSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partition(int[] nums, int start, int end) {
        int pivot = nums[0];

        // find the minimum numbers than pivot
        int count = 0;
        for(int i = start + 1; i <= end; i++) {
            if(nums[i] <= pivot) {
               count++;
            }
        }

        // place pivot at right index
        int pivotIndex = start + count;

        int temp = nums[pivotIndex];
        nums[pivotIndex] = nums[start];
        nums[start] = temp;

        // shuffle left and right side
        int i = start, j = end;
        while(i < pivotIndex && j > pivotIndex) {
            while(nums[i] <= pivot) i++;
            while(nums[j] > pivot) j--;
            if(i < pivotIndex && j > pivotIndex) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        return pivotIndex;
    }

    public static void sort(int[] nums, int start, int end) {
        if(start >= end) return;

        int pivot = partition(nums, start, end);
        sort(nums, 0, pivot - 1);
        sort(nums, pivot + 1, end);
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, 2, 4, 1};
        sort(nums, 0, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }
}
