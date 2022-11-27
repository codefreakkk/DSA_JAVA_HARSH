package contests.leetcode.WeeklyContest317;

import java.util.*;

public class ProblemB {
    public static List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        int size = creators.length;

        HashMap<String, Long> totalViews = new HashMap<>();
        HashMap<String, String> id = new HashMap<>();
        HashMap<String, Integer> highestViews = new HashMap<>();

        long maxi = Integer.MIN_VALUE;
        for(int i = 0; i < size; i++) {
            long total = totalViews.getOrDefault(creators[i], 0l);
            total += views[i];
            totalViews.put(creators[i], total);

            int highest = highestViews.getOrDefault(creators[i], -1);
            if(highest == views[i]) {
                String existingId = id.get(creators[i]);
                if(existingId.compareTo(ids[i]) > 0) {
                    // current i'th id is smaller
                    id.put(creators[i], ids[i]);
                }
            }
            if(highest < views[i]) {
                highestViews.put(creators[i], views[i]);
                id.put(creators[i], ids[i]);
            }

            maxi = Math.max(maxi, total);
        }

        // find answer
        List<List<String>> result = new ArrayList<>();
        for(Map.Entry<String, Long> e : totalViews.entrySet()) {
            if(e.getValue() == maxi) {
                List<String> output = new ArrayList<>();
                output.add(e.getKey());
                output.add(id.get(e.getKey()));
                result.add(output);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        String creators[] = {"alice","bob","alice","chris"};
        String ids[] = {"one","two","three","four"};
        int[] views = {5,10,5,4};

        List<List<String>> ans = mostPopularCreator(creators, ids, views);
        for(List<String> l : ans) {
            System.out.println(l);
        }
    }
}
