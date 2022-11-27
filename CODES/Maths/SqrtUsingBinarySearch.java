package Maths;

public class SqrtUsingBinarySearch {
    public static double mySqrt(int n) {
        int start = 0;
        int end = n;
        int precision = 3;
        double ans = 0.0;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(mid * mid == n) return mid;
            else if(mid * mid > n) end = mid - 1;
            else start = mid + 1;

            double increment = 0.1;
            for(int i = 0; i < precision; i++) {
               while(ans * ans <= n) {
                   ans += increment;
               }

               ans -= increment;
               increment /= 10;
           }
        }

        return ans;
    }
    
    public static void main(String[] args) {
        System.out.println(mySqrt(40));
    }
}
