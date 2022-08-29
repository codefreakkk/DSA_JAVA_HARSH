package two_pointers;

public class MinimumPlatformsRequired {
    public static int findPlatform(int[] nums, int[] dep, int n) {
        int maxi = Integer.MIN_VALUE;
        int platform = 0;
        int i = 0, j = 0;

        while(i < n) {
            if(nums[i] <= dep[j]) {
                platform += 1;
                i++;
            } else {
                platform -= 1;
                j++;
            }
            maxi = Integer.max(platform, maxi);
        }

        return maxi;
    }

    public static void main(String[] args) {
        int[] nums = {900, 1100, 1235};
        int[] dep = {1000, 1200, 1240};
        System.out.println(findPlatform(nums, dep, nums.length));
    }
}
