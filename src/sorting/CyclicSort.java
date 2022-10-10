package sorting;

import java.util.Arrays;

public class CyclicSort {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void sort(int[] nums) {
        int i = 0;
        int size = nums.length;

        while(i < size) {
            if(nums[i] - 1 == i) i++;
            else {
                // swap with nums[i] - 1
                swap(nums, i, nums[i] - 1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
}
