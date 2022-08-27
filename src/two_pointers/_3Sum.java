package two_pointers;

import java.util.*;

public class _3Sum {

    //    o(n^3) solution will not work
    public static List<List<Integer>> threeSum1(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();
        int size = nums.length;

        for(int i = 0; i < size - 1; i++) {
            for(int j = i + 1; j < size - 1; j++) {
                for(int k = j + 1; k < size - 1; k++) {
                    if((nums[i] + nums[j] + nums[k]) == 0) {
                        List<Integer> ans = new ArrayList<>();
                        ans.add(nums[i]);
                        ans.add(nums[j]);
                        ans.add(nums[k]);
                        Collections.sort(ans);
                        set.add(ans);
                    }
                }
            }
        }

        List<List<Integer>> answer = new ArrayList<>(set);
        return answer;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> answer = new ArrayList<>();
        int size = nums.length;

        for(int i = 0; i < size - 2; i++) {
            if(i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int low = i + 1;
                int high = size - 1;
                int sum = 0 - nums[i];

                while(low < high) {
                    if(nums[low] + nums[high] == sum) {
                        answer.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        while(low < high && nums[low] == nums[low + 1]) low++;
                        while(low < high && nums[high] == nums[high - 1]) high--;
                        low++;
                        high--;
                    }
                    else if(nums[low] + nums[high] < sum) low++;
                    else high--;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> ans = threeSum(nums);

        for(List<Integer> i : ans) {
            System.out.println(i);
        }
    }
}