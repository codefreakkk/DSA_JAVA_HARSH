package array;

public class FindMissingAndRepeatingNumber {
    public static int getRightMostBit(int num) {
        int count = 0;
        int setBit = 0;
        while(setBit != 1) {
            setBit = num & 1;
            num = num >> 1;
            count++;
        }
        return count - 1;
    }

    public static boolean isRightBitSet(int num, int index) {
        if((num & (1 << index)) != 0) {
            return true;
        } else {
            return false;
        }
    }

    public static int[] findTwoElement(int[] arr, int n) {
        int x = 0;
        for(int i = 0; i < n; i++) {
            x ^= arr[i];
        }

        int y = 0;
        for(int i = 1; i <= n; i++) {
            y ^= i;
        }
        int num = x ^ y;

        int index = getRightMostBit(num);
        int basket1 = 0;
        int basket2 = 0;
        for(int i = 0; i < n; i++) {
            if(isRightBitSet(arr[i], index)) {
                basket1 ^= arr[i];
            } else {
                basket2 ^= arr[i];
            }
        }

        for(int i = 1; i <= n; i++) {
            if(isRightBitSet(i, index)) {
                basket1 ^= i;
            } else {
                basket2 ^= i;
            }
        }

        int repeating = -1;
        int missing = -1;
        for(int i = 0; i < n; i++) {
            if(basket1 == arr[i]) {
                repeating = basket1;
                missing = basket2;
                break;
            }
            if(basket2 == arr[i]) {
                repeating = basket2;
                missing = basket1;
                break;
            }
        }

        int[] answer = new int[2];
        answer[0] = repeating;
        answer[1] = missing;

        return answer;
    }

    public static void main(String[] args) {
        int[] arr = {4, 3, 5, 2, 2, 1};
        int[] ans = findTwoElement(arr, arr.length);

        for(int i : ans) {
            System.out.println(i);
        }
    }
}