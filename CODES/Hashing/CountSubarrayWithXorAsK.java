package Hashing;

import java.util.HashMap;

public class CountSubarrayWithXorAsK {
    public static int subarrayWithXor(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int size = nums.length;
        int xor = 0, count = 0;

        for(int i = 0; i < size; i++) {
            xor ^= nums[i];
            if(xor == k) count++;
            if(map.containsKey(xor ^ k)) count += map.get(xor ^ k);
            if(map.containsKey(xor)) map.put(xor, map.get(xor) + 1);
            else map.put(xor, 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {5, 6, 7, 8, 9};
        int k = 5;
        System.out.println(subarrayWithXor(nums, k));
    }
}
