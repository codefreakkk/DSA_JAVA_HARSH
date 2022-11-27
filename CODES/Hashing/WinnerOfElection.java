package Hashing;

import java.util.*;

public class WinnerOfElection {

//    Tc : o(NlogN) + o(N), SC : o(N)
    public static String[] winner1(String[] arr, int n) {
        Arrays.sort(arr);
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }

        int maxi = Integer.MIN_VALUE;
        String ans[] = new String[2];
        for(int i = 0; i < n; i++) {
            if(map.get(arr[i]) > maxi) {
                ans[0] = arr[i];
                ans[1] = String.valueOf(map.get(arr[i]));
                maxi = map.get(arr[i]);
            }
        }

        return ans;
    }

    public static String[] winner(String[] arr, int n) {
        HashMap<String, Integer> map = new HashMap<>();

        for(int i = 0; i < n; i++) {
            if(map.containsKey(arr[i])) map.put(arr[i], map.get(arr[i]) + 1);
            else map.put(arr[i], 1);
        }

        int maxVote = 0;
        String name = "";
        String[] ans = new String[2];
        for(int i = 0; i < n; i++) {
            int vote = map.get(arr[i]);
            String key= arr[i];

            if(vote > maxVote) {
                maxVote = vote;
                name = key;
            } else if(vote == maxVote) {
                if(key.compareTo(name) < 0) name = key;
            }
        }

        ans[0] = name;
        ans[1] = String.valueOf(maxVote);
        return ans;
    }

    public static void main(String[] args) {
        String[] values = {"john", "mike", "harry", "ron", "rob"};
        String[] ans = winner(values, values.length);
        System.out.println(Arrays.toString(ans));
    }
}
