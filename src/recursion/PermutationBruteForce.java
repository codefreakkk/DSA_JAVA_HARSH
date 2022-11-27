package recursion;

import java.util.*;

public class PermutationBruteForce {
    // permutation bruteforce approach
    static void permute(int[] nums, boolean[] map, List<Integer> output) {
        if(output.size() == nums.length) {
            System.out.println(output);
            return;
        }
        for(int i = 0; i < nums.length; i++) {
            if(!map[i]) {
                output.add(nums[i]);
                map[i] = true;
                permute(nums, map, output);
                output.remove(output.size() - 1);
                map[i] = false;
            }
        }
    }
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        boolean[] map = new boolean[nums.length];
        permute(nums, map, new ArrayList<Integer>());
    }
}
