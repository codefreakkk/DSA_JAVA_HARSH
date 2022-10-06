package Maths;

public class NewtonRaphsonMethod {
    public static double sqrt(int n) {
        double x = n;
        double root = 0.0;

        while(true) {
            root = 0.5 * (x + (n / x));

            // if answer found
            if(Math.abs(root - x) < 1) break;

            x = root;
        }

        return root;
    }

    public static void main(String[] args) {
        System.out.println(sqrt(4));
    }
}
