package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int[] nums) {
        int n = nums.length;

        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j > 0; j--) {
                if(nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                }
                else break;
            }
        }

        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 2};
        sort(nums);
    }
}
