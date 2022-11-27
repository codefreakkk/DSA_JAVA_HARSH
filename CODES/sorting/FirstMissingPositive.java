package sorting;

public class FirstMissingPositive {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int firstMissingPositive(int[] nums) {
        int size = nums.length;

        // sort array first
        int i = 0;
        while(i < size) {
            int correct = nums[i] - 1;
            if(nums[i] > 0 && nums[i] < size && nums[i] != nums[correct]) {
                swap(nums, i, correct);
            }
            else i++;
        }

        // find first missing positive
        for(int j = 0; j < size; j++) {
            if(nums[j] != j + 1) return j + 1;
        }

        return size + 1;
    }

    public static void main(String[] args) {
        int[] nums = {7,8,9,11,12};
        System.out.println(firstMissingPositive(nums));
    }
}
