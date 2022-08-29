package two_pointers;

import java.util.*;

class RemoveDuplicatesFromSortedArray {

    //    this solution is brute force TC : o(n) + o(n) + o(NLogN), SC : o(n) + o(n)
    public static int removeDuplicates1(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) set.add(nums[i]);

        int setSize = set.size();
        List<Integer> list = new ArrayList<>(set);

        Collections.sort(list);
        for(int i = 0; i < setSize; i++) nums[i] = list.get(i);

        return setSize;
    }

    public static int removeDuplicates(int[] nums) {
        if(nums.length == 1) return nums[0];
        int i = 0;
        int j = 1;

        while(j < nums.length) {
            if(nums[i] == nums[j]) j++;
            if(i < nums.length && nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
                j++;
            }
        }

        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        System.out.println(removeDuplicates(nums));
    }
}