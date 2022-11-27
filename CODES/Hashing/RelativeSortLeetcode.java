package Hashing;

import java.lang.reflect.Array;
import java.util.*;

public class RelativeSortLeetcode {
    public static int[] relativeSortArray(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < nums2.length; i++){
            map2.put(nums2[i],i);
        }

        List<Integer> remain = new ArrayList<>();
        for(int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], map.getOrDefault(nums1[i], 0) + 1);
            if(!map2.containsKey(nums1[i])) {
                remain.add(nums1[i]);
            }
        }

        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums2.length; i++) {
            if(map.containsKey(nums2[i])) {
                int count = map.get(nums2[i]);
                while(count > 0) {
                    list.add(nums2[i]);
                    count--;
                }
                map.remove(nums2[i]);
            }
        }

        Collections.sort(remain);
        for(int i = 0; i < remain.size(); i++) {
            list.add(remain.get(i));
        }

        int[] answer = list.stream().mapToInt(Integer::intValue).toArray();
        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {2,3,1,3,2,4,6,7,9,2,19};
        int[] nums2 = {1};

        int[] ans = relativeSortArray(nums1, nums2);
        System.out.println(Arrays.toString(ans));
    }
}
