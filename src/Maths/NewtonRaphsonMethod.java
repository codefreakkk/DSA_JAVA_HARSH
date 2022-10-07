package Maths;

public class NewtonRaphsonMethod {
    public static double sqrt(int n, double prec) {
        double x = n;
        double root;

        while(true) {
            root = 0.5 * (x + (n / x));

            // if answer found
            // instead of prec you can also pass 1 in if condition
            if(Math.abs(root - x) < prec) {
                break;
            }

            x = root;
        }

        return root;
    }

    public static void main(String[] args) {
        // converted to integer
        System.out.println((int)sqrt(8, 1e-3));
    }
}
