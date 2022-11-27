package recursion;

import java.util.Arrays;

public class OuickSort {
    public static void quickSort(int arr[], int start, int end) {
        if(start >= end) {
            return;
        }
        int low = start;
        int high = end;
        int mid = (start + end) / 2;
        int pivot = arr[mid];
        while(start <= end) {
            while(arr[start] < pivot) {
                start++;
            }
            while(arr[end] > pivot) {
                end--;
            }
            if(start <= end) {
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }
        quickSort(arr, low,  end);
        quickSort(arr, start, high);
    }
    public static void main(String[] args) {
        int arr[] = {4, 5, 6, 8, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}

