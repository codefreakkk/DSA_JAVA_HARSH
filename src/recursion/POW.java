package recursion;

public class POW {
    public static int pow(int x, int n) {
        if(n == 1) {
            return x;
        }
        return x * pow(x, n - 1);
    }

    // revision
    public static int powRevision(int x, int n) {
        if(n == 1) return x;
        return x * powRevision(x, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(powRevision(3, 3));
    }
}
