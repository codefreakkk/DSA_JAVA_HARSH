package Maths.Bitmanipulation;

public class FindNumberThatAppearsOddNumberOfTimes {
    public static int getOddOccurrence(int[] nums) {
        int size = nums.length;

        int result = 0;
        for(int i = 0; i < size; i++) {
            result ^= nums[i];
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2, 3, 1, 3};
        System.out.println(getOddOccurrence(nums));
    }
}
