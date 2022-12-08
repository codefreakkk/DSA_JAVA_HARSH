package trees.SegmentTrees;

import java.util.*;

public class SegmentTree {
    static int[] arr = new int[100005];
    static int[] segment = new int[4 * 100005];

    public static void build(int index, int low, int high) {
        if (low == high) {
            segment[index] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        int leftIndex = (2 * index) + 1;
        build(leftIndex, low, mid);

        int rightIndex = (2 * index) + 2;
        build(rightIndex, mid + 1, high);

        segment[index] = Math.max(segment[leftIndex], segment[rightIndex]);
    }

    public static int query(int index, int low, int high, int leftRange, int rightRange) {
        // if completely lies
        if (low >= leftRange && high <= rightRange)
            return segment[index];

        // if does not lies
        if (high < leftRange || low > rightRange)
            return Integer.MIN_VALUE;

        // if overalaps
        int mid = (low + high) / 2;

        int leftIndex = 2 * index + 1;
        int left = query(leftIndex, low, mid, leftRange, rightRange);

        int rightIndex = 2 * index + 2;
        int right = query(rightIndex, mid + 1, high, leftRange, rightRange);

        return Math.max(left, right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++)
            arr[i] = i + 1;

        for (int i = 0; i < n; i++) 
            System.out.print(arr[i] + " ");
        
        System.out.println();   

        System.out.println("Enter left range");
        int leftRange = sc.nextInt();
        System.out.println("Enter right range");
        int rightRange = sc.nextInt();

        //  build tree
        build(0, 0, n - 1);

        // query tree
        int answer = query(0, 0, n - 1, leftRange, rightRange);
        System.out.println(answer);
    }
}
