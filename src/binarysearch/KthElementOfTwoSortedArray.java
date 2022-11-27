package binarysearch;

public class KthElementOfTwoSortedArray {
    public static long kthElement(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;

        int start = Math.max(0, k - m);
        int end = Math.min(k, n);

        while(start <= end) {
            int cut1 = (start + end) / 2;
            int cut2 = k - cut1;

            // divide array on the basis of cuts
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == m ? Integer.MAX_VALUE : nums2[cut2];


            // check for possible answer or move left or right
            if(l1 <= r2 && l2 <= r1) {
                return Math.max(l1, l2);
            }
            else if(l1 > r2) {
                end = cut1 - 1;
            }
            else start = cut1 + 1;
        }

        return 1;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 3, 6, 7, 9};
        int[] nums2 = {1, 4, 8, 10};
        int k = 5;
        System.out.println(kthElement(nums1, nums2, k));
    }
}
