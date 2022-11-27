package REVISION.recursion;

import java.util.Arrays;

public class PartitionArrayToKSubsets {
    public static boolean solve(int[] nums, int k, int sum, int count, int target, boolean[] visited) {
        if(count == k - 1) return true;
        if(sum > target) return false;
        if(sum == target) {
            if(solve(nums, k, 0, count + 1, target, visited)) return true;
        }

        for(int i = 0; i < nums.length; i++) {
            if(!visited[i]) {
                visited[i] = true;
                if(solve(nums, k, sum + nums[i], count, target, visited)) return true;
                visited[i] = false;
            }
        }

        return false;
    }

    public static boolean isKPartitionPossible(int[] nums, int n, int k) {
        int sum = Arrays.stream(nums).boxed().mapToInt(i->i).sum();
        if(sum % k != 0) return false;

        boolean[] visited = new boolean[nums.length];
        Arrays.fill(visited, false);

        return solve(nums, k, 0, 0, sum / k, visited);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        int k = 3;

        System.out.println(isKPartitionPossible(nums, nums.length, k));
    }
}
