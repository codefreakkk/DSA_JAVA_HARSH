package two_pointers;

public class RainwaterTrapping {

    //    prefix sum and suffix sum solution this solution can be optimized with two pointers
    public static int trap1(int[] height) {
        int size = height.length;
        int[] prefixSum = new int[size];
        int[] suffixSum = new int[size];

        prefixSum[0] = height[0];
        for(int i = 1; i < size; i++) {
            prefixSum[i] = Math.max(prefixSum[i - 1], height[i]);
        }

        suffixSum[size - 1] = height[size - 1];
        for(int i = size - 2; i >= 0; i--) {
            suffixSum[i] = Math.max(suffixSum[i + 1], height[i]);
        }

        int result = 0;
        for(int i = 0; i < size; i++) {
            result += (Math.min(prefixSum[i], suffixSum[i]) - height[i]);
        }

        return result;
    }

//    two pointer solution - this is an optimal approach with TC : o(n)
    public static int trap(int[] height) {
        int size = height.length;
        int low = 0;
        int high = size - 1;
        int result = 0;
        int leftMax = Integer.MIN_VALUE, rightMax = Integer.MIN_VALUE;

        while(low <= high) {
            if(height[low] <= height[high]) {
                if(height[low] > leftMax) leftMax = height[low];
                else result += leftMax - height[low];
                low++;
            } else {
                if(height[high] > rightMax) rightMax = height[high];
                else result += rightMax - height[high];
                high--;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = {4,2,0,3,2,5};
        System.out.println(trap(nums));
    }
}