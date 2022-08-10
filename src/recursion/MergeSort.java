package recursion;
public class MergeSort {
    public static void merge(int arr[], int start, int mid, int end) {
        int mix[] = new int[end - start + 1];
        int index1 = start;
        int index2 = mid + 1;
        int x = 0;
        while(index1 <= mid && index2 <= end) {
            if(arr[index1] <= arr[index2]) {
                mix[x++] = arr[index1++];
            } else {
                mix[x++] = arr[index2++];
            }
        }
        while(index1 <= mid) {
            mix[x++] = arr[index1++];
        }
        while(index2 <= end) {
            mix[x++] = arr[index2++];
        }
//        add the element from mix array to original array
        for (int i = 0, j = start; i < mix.length; i++, j++) {
            arr[j] = mix[i];
        }
    }
    public static void divide(int arr[], int start, int end) {
        if(start >= end) {
            return;
        }
        int mid = start + (end - start) / 2;
        divide(arr, start, mid);
        divide(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void main(String[] args) {
        int a[] = {5, 4, 3, 2, 1};
        divide(a, 0, a.length - 1);
        for(int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
