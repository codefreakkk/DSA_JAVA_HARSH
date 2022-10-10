package sorting;

import java.util.Arrays;

public class SetMismatch {
    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int[] findError(int[] nums) {
        int size = nums.length;
        int[] ans = new int[2];
        int i = 0;

        while(i < size) {
            int correct = nums[i] - 1;
            if(nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else i++;
        }

        // find repeating and  missing number
        for(int j = 0; j < nums.length; j++) {
            if(nums[j] != j + 1) {
                ans[0] = nums[j];
                ans[1] = j + 1;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 1};
        int[] ans = findError(nums);
        System.out.println(Arrays.toString(ans));
    }
}
