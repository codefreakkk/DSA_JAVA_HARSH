package Maths.Bitmanipulation;

public class RemoveDuplicates {
    public static int unique(int[] nums) {
        int unique = 0;
        for(int i : nums) {
            unique ^= i;
        }

        return unique;
    }

    public static void main(String[] args) {
        int[] nums = {2, 3, 3, 4, 2, 6, 4};
        System.out.println(unique(nums));
    }
}
