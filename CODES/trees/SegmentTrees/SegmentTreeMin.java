package trees.SegmentTrees;

public class SegmentTreeMin {

    public static void build(int[] segment, int[] arr, int index, int low, int high) {
        if (low == high) {
            segment[index] = arr[low];
            return;
        }

        int mid = (low + high) / 2;

        int leftIndex = 2 * index + 1;
        build(segment, arr, leftIndex, low, mid);

        int rightIndex = 2 * index + 2;
        build(segment, arr, rightIndex, mid + 1, high);

        segment[index] = Math.min(segment[leftIndex], segment[rightIndex]);
    }

    public static int[] constructST(int arr[], int n) {
        int[] segment = new int[4 * n];
        build(segment, arr, 0, 0, n - 1);
        return segment;
    }

    // RMQ helper
    public static int query(int[] segment, int index, int low, int high, int leftRange, int rightRange) {
        // if completely lies
        if (low >= leftRange && high <= rightRange)
            return segment[index];

        // if does not lies
        if (high < leftRange || low > rightRange)
            return Integer.MAX_VALUE;

        // if overalaps
        int mid = (low + high) / 2;

        int leftIndex = 2 * index + 1;
        int left = query(segment, leftIndex, low, mid, leftRange, rightRange);

        int rightIndex = 2 * index + 2;
        int right = query(segment, rightIndex, mid + 1, high, leftRange, rightRange);

        return Math.min(left, right);
    }

    public static int RMQ(int segment[], int n, int l, int r) {
        int answer = query(segment, 0, 0, n - 1, l, r);
        return answer;
    }
}
