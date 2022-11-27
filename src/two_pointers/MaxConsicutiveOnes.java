package two_pointers;

public class MaxConsicutiveOnes {

//    TC : o(N), SC : o(1)
    public static int findMaxConsicutiveOnes(int[] nums) {
        int maxi = Integer.MIN_VALUE;
        int cnt = 0, size = nums.length;

        for(int i = 0; i < size; i++) {
            if(nums[i] == 0) {
                maxi = Math.max(cnt, maxi);
                cnt = 0;
            }
            else cnt += 1;
        }

        maxi = Math.max(cnt, maxi);
        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 1};
        System.out.println(findMaxConsicutiveOnes(nums));
    }
}