package contests.leetcode.weeklyContest313;


// problem not solved (so close yet so far)
public class ProblemC {
    public static int countSetBits(int n) {
        int bitCount = 0;
        while(n > 0) {
            bitCount += n & 1;
            n >>= 1;
        }
        return bitCount;
    }

    public static int minimizeXor(int num1, int num2) {
        // find same bits for num2
        int num2BitCount = countSetBits(num2);
        int ans = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 1; i <= 10e9 + 1; i++) {
            int bit = countSetBits(i);
            if(bit == num2BitCount) {
                int xor = num1 ^ i;
                if(min > xor) {
                    ans = i;
                    min = xor;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println(minimizeXor(64, 40)); // ans 65
//        System.out.println(countSetBits(64 ^ 65));
    }
}
