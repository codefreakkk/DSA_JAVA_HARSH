package Hashing;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays {
    public static int numberOfIntersectionInTwoArrays(int[] nums1, int[] nums2, int n, int m) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) set.add(nums1[i]);

        int count = 0;
        for(int i = 0; i < m; i++) {
            if(set.contains(nums2[i])) {
                count++;
                set.remove(nums2[i]);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {89, 24, 75, 11, 23};
        int[] nums2 = {89, 2, 89};
        System.out.println(numberOfIntersectionInTwoArrays(nums1, nums2, nums1.length, nums2.length));
    }
}
