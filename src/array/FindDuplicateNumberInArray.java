package array;

import java.util.*;

public class FindDuplicateNumberInArray {

//    this solution only works for limited amount of array
//    Solution uses Hashing : TC o(n), SC o(n)
    public static int findDuplicate1(int[] nums) {
        int[] visited = new int[nums.length + 1];
        int n = visited.length;
        int answer = -1;

        for(int i = 0; i < n; i++) {
            if(visited[nums[i]] == 1) {
                answer = nums[i];
                break;
            } else {
                visited[nums[i]] = 1;
            }
        }
        return answer;
    }

//    GFG Problem worked successfully
//    TC : o(n), SC : o(n)
    public static ArrayList<Integer> findDuplicateGFG(int nums[], int n) {
        int[] visited = new int[n];
        Set<Integer> ans = new HashSet<>();

        for(int i = 0; i < n; i++) {
            if(visited[nums[i]] == 1) {
                ans.add(nums[i]);
            } else {
                visited[nums[i]] = 1;
            }
        }

        ArrayList answer = new ArrayList<>(ans);
        if(answer.size() == 0) {
            answer.add(-1);
        }
        Collections.sort(answer);
        return answer;
    }

    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while(slow != fast);

        slow = nums[0];
        while(slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main(String[] args) {
        int[] nums = {0,3,1,3, 2, 2};
        System.out.println(findDuplicateGFG(nums, nums.length));
    }
}