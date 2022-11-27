package array;

public class PowOfXandN {
    public static double myPow(double x, int nn) {
        double ans = 1.0;
        long n = nn;
        if(nn < 0) n = -nn;

        while(n > 0) {
            if(n % 2 == 1) {
                ans *= x;
                n -= 1;
            } else {
                x *= x;
                n /= 2;
            }
        }

        if(nn < 0) ans = (double) 1.0 / (double) ans;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(myPow(2.0, 10));
    }
}