package array;

public class GridUniquePaths {
    public static int uniquePaths(int n, int m) {
        int N = (n + m) - 2;
        int r = n - 1;
        int res = 1;

        for(int i = 1; i <= r; i++) {
            res *= (N - r + i) / i;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 2;
        System.out.println(uniquePaths(n, m));
    }
}
