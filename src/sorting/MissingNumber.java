package sorting;

public class MissingNumber {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int missingNumber(int[] nums) {
        int size = nums.length;
        int i = 0;

        // sort the array first
        while(i < size) {
            if(nums[i] != i && nums[i] != size) {
                swap(nums, nums[i], i);
            }
            else i++;
        }

        // check for missing number
        for(int j = 0; j < size; j++) {
            if(j != nums[j]) return j;
        }

        return size;
    }

    public static void main(String[] args) {
        int[] nums = {3,0,1};
        int ans = missingNumber(nums);
        System.out.println(ans);
    }
}
