package Maths;

public class GCDEuclideanAlgorithm {

    // iterative solution
    public static int gcdIteration(int a, int b) {
        if(a == 0) return b;
        if(b == 0) return a;

        int ans = 0;
        while(b != 0) {
            b = b % a;
            ans = a;
            a = b;
        }

        return ans;
    }

    // recursive solution
    public static int gcdRecursion(int a, int b) {
        if(a == 0) return b;
        return gcdRecursion(b % a, a);
    }

    public static void main(String[] args) {
        System.out.println(gcdRecursion(2, 8));
    }
}
