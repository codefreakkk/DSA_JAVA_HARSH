package two_pointers;

import java.util.*;

public class _4Sum {
    //    brute force approach this approach will not work for bigger integers
    public static void binarySearch(int[] nums, int i, int j, int k, int low, int high, long target, Set<List<Integer>> ans) {
        if (low < nums.length) {
            while (low <= high) {
                int mid = (low + high) / 2;

                if (nums[mid] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[j]);
                    list.add(nums[k]);
                    list.add(nums[mid]);
                    Collections.sort(list);
                    ans.add(list);
                    break;
                } else if (nums[mid] < target) low = mid + 1;
                else high = mid - 1;
            }
        }
    }

    public static List<List<Integer>> fourSum1(int[] nums, int target) {
        Arrays.sort(nums);
        Set<List<Integer>> ans = new HashSet<>();
        int size = nums.length;
        for (int i = 0; i < size - 2; i++) {
            for (int j = i + 1; j < size - 1; j++) {
                for (int k = j + 1; k < size - 1; k++) {
                    int low = k + 1;
                    int high = size - 1;
                    long sum = nums[i] + nums[j] + nums[k];
                    long remain = target - sum;
                    binarySearch(nums, i, j, k, low, high, remain, ans);
                }
            }
        }
        List<List<Integer>> answer = new ArrayList<>(ans);
        return answer;
    }

    //    optimized approach
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> answer = new ArrayList<>();
        int size = nums.length;
        Arrays.sort(nums);

        int i = 0;
        for (i = 0; i < size - 3; i++) {
            for (int j = i + 1; j < size - 2; j++) {
                int low = j + 1;
                int high = size - 1;
                long remain = (long) target - nums[j] - nums[i];

                while (low < high) {
                    int totalValue = nums[low] + nums[high];
                    if (totalValue == remain) {
                        answer.add(Arrays.asList(nums[i], nums[j], nums[low], nums[high]));
                        while (low < high && nums[low] == nums[low + 1]) {
                            low++;
                        }
                        while (low < high && nums[high] == nums[high - 1]) {
                            high--;
                        }
                        low++;
                        high--;
                    }
                    else if (totalValue < remain) low++;
                    else high--;
                }
                while (j + 1 < size && nums[j] == nums[j + 1]) j++;
            }
            while (i + 1 < size && nums[i] == nums[i + 1]) i++;
        }
        return answer;
    }



    public static void main(String[] args) {
        int[] nums = {1,0,-1,0,-2,2};
        int target = 0;
        List<List<Integer>> ans = fourSum(nums, target);
        for(List<Integer> i : ans) {
            System.out.println(i);
        }
    }
}
