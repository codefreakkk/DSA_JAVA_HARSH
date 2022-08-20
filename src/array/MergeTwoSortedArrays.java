package array;

import java.util.Arrays;

public class MergeTwoSortedArrays {

    //    brute force approach TC : o(n1 * m1);
//    public static void swap(long[] arr1, long[] arr2, int x, int y) {
//        long temp = arr1[x];
//        arr1[x] = arr2[y];
//        arr2[y] = temp;
//    }
//
//    public static void merge1(long[] arr1, long[] arr2, int n, int m) {
//        for(int i = 0; i < n; i++) {
//            if(arr1[i] > arr2[0]) {
//                swap(arr1, arr2, i, 0);
//                Arrays.sort(arr2);
//            }
//        }
//    }


    // gap algo most optimized algo for this problem TC : o(logN) * n, SC : o(1)
    public static int nextGap(int gap) {
        if(gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }

    public static void merge(long[] arr1, long[] arr2, int n, int m) {
        int i = 0, j = 0, gap = n + m;
        for(gap = nextGap(gap); gap > 0; gap = nextGap(gap)) {
            for(i = 0; i + gap < n; i++) {
                if(arr1[i] > arr1[i + gap]) {
                    long temp = arr1[i];
                    arr1[i] = arr1[i + gap];
                    arr1[i + gap] = temp;
                }
            }

            for(j = (gap > n) ? gap - n : 0; j < m && i < n; j++, i++) {
                if(arr1[i] > arr2[j]) {
                    long temp = arr1[i];
                    arr1[i] = arr2[j];
                    arr2[j] = temp;
                }
            }

            if(j < m) {
                for(j = 0; j + gap < m; j++) {
                    if(arr2[j] > arr2[j + gap]) {
                        long temp = arr2[j];
                        arr2[j] = arr2[j + gap];
                        arr2[j + gap] = temp;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        long[] arr1 = {1, 35};
        long[] arr2 = {6, 9, 13, 15, 20, 25, 29, 46};
        int n = arr1.length;
        int m = arr2.length;
        merge(arr1, arr2, n, m);
        for(long i : arr1) {
            System.out.println(i);
        }
        for(long i : arr2) {
            System.out.println(i);
        }
    }
}