package binarysearch;

public class MedianOfTwoSortedArrayOfDifferentSizes {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        int start = 0;
        int end = n1;

        while(start <= end) {
            int mid = start + (end - start) / 2;

            int cut1 = mid;
            int cut2 = ((n1 + n2 + 1) / 2) - cut1;

            // take elements from array
            int l1 = cut1 == 0 ? Integer.MIN_VALUE : nums1[cut1 - 1];
            int l2 = cut2 == 0 ? Integer.MIN_VALUE : nums2[cut2 - 1];
            int r1 = cut1 == n1 ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = cut2 == n2 ? Integer.MAX_VALUE : nums2[cut2];


            // check for valid conditions

            // if median fount
            if(l1 <= r2 && l2 <= r1) {
                // if length is odd return max of l1 and l2
                if((n1 + n2) % 2 == 1) return Math.max(l1, l2);

                // if length is even return average
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
            }
            // if l1 > r2 then move left
            else if(l1 > r2)  {
                end = mid - 1;
            }
            // if l2 > r1 then move right
            else {
                start = mid + 1;
            }
        }

        return 0.0;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
}
