package sorting;

public class FindTheDuplicateNumber {
    public static void swap(int[] nums, int i, int j) {
        nums[i] = nums[i] ^ nums[j];
        nums[j] = nums[i] ^ nums[j];
        nums[i] = nums[i] ^ nums[j];
    }

    public static int findDuplicate(int[] nums) {
        int size = nums.length;

        int i = 0;
        while(i < size) {
            if(nums[i] != i + 1) {
                int correct = nums[i] - 1;
                if(nums[i] != nums[correct]) swap(nums, i, correct);
                else return nums[i];
            }
            else i++;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] nums = {3,1,3,4,2};
        System.out.println(findDuplicate(nums));
    }
}
