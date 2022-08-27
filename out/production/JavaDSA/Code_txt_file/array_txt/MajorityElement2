package array;

import java.util.*;

public class MajorityElement2 {
    public static List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int cnt1 = 0, cnt2 = 0;
        int num1 = 0, num2 = 0;
        int n = nums.length;

        for(int i = 0; i < n; i++) {
            int element = nums[i];
            if(element == num1) cnt1++;
            else if(element == num2) cnt2++;
            else if(cnt1 == 0) {
                num1 = nums[i];
                cnt1 = 1;
            } else if(cnt2 == 0) {
                num2 = nums[i];
                cnt2 = 1;
            } else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1 = 0;
        cnt2 = 0;
        for(int i = 0; i < n; i++) {
            if(num1 == nums[i]) cnt1++;
            if(num2 == nums[i]) cnt2++;
        }

        if(cnt1 > n / 3) ans.add(num1);
        if(cnt2 > n / 3) ans.add(num2);
        if(num1 == 0 && num2 == 0) {
            ans.removeAll(ans);
            ans.add(0);
        }
        return ans;
    }

    public static void main(String[] args) {
        int nums[] = {1, 1, 1, 3, 3, 2, 2, 2};
        List<Integer> i = majorityElement(nums);
        System.out.println(i);
    }
}