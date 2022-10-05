package binarysearch;

public class NthRootOfANumberUsingBinarySearch {
    public static double multiply(double mid, int n) {
        double ans = 1.0;
        for(int i = 1; i <= n; i++) {
            ans *= mid;
        }

        return ans;
    }

    public static double nthRoot(int n, int x) {
        double start = 1;
        double end = x;
        double eps = 1e-6;

        while((end - start) > eps) {
            double mid = (end + start) / 2.0;

            if(multiply(mid, n) == x) return mid;
            if(multiply(mid, n) < x) start = mid;
            else end = mid;
        }

        return start;
    }

    public static void main(String[] args) {
        System.out.println(nthRoot(2, 4));
    }
}
