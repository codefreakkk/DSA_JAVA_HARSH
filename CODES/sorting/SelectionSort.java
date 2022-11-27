package sorting;

import java.util.Arrays;

public class SelectionSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int findMax(int[] nums, int n) {
        int max = nums[0];
        int index = 0;

        for(int i = 1; i < n; i++) {
            if(nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }

        return index;
    }

    public static void selectionSort(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int max = findMax(nums, n - i);

            // swap ith and n - i - 1 index
            swap(nums, max, n - i - 1);
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {4, 5, 1, 2, 3};
        selectionSort(nums);
    }
}
