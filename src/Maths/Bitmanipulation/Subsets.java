package Maths.Bitmanipulation;

import java.util.*;

public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        int size = nums.length;
        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < (1 << size); i++) {
            List<Integer> output = new ArrayList<>();
            int bit = i;
            int position = 0;

            while(bit > 0) {
                if((bit & 1) > 0) output.add(nums[position]);
                position++;
                bit >>= 1;
            }
            ans.add(output);
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ans = subsets(nums);

        for(List<Integer> l : ans) {
            System.out.println(l);
        }
    }
}
