package recursion;

import java.util.*;

public class SubSequence {
    public static void subSeq(String processed, String str) {
        if(str.isEmpty()) {
            System.out.println(processed);
            return;
        }
        char initial = str.charAt(0);
        subSeq(processed + initial, str.substring(1));
        subSeq(processed, str.substring(1));
    }

    public static ArrayList<String> subSeqWithArrayList(String processed, String str) {
        if(str.isEmpty()) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add(processed);
            return arr;
        }
        char initial = str.charAt(0);
        ArrayList<String> left =  subSeqWithArrayList(processed + initial, str.substring(1));
        ArrayList<String> right = subSeqWithArrayList(processed, str.substring(1));
        left.addAll(right);
        return left;
    }

//    subsequence in iterative way
    public static List<List<Integer>> subSeqIterative(int arr[]) {
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());

        for(int nums : arr) {
            int n = outerList.size();
            for(int i = 0; i < n; i++) {
                List<Integer> internalList = new ArrayList<>(outerList.get(i));
                internalList.add(nums);
                outerList.add(internalList);
            }
        }

        return outerList;
    }

    static List<List<Integer>> subSequenceRemoveDuplicates(int arr[]) {
        Arrays.sort(arr);
        List<List<Integer>> outerList = new ArrayList<>();
        outerList.add(new ArrayList<>());
        int start = 0;
        int end = 0;

        for(int i = 0; i < arr.length; i++) {
            start = 0;
            if(i > 0 && arr[i] == arr[i - 1]) {
                start = end + 1;
            }
            end = outerList.size() - 1;
            int size = outerList.size();
            for(int j = start; j < size; j++) {
                List<Integer> intenalList = new ArrayList<>(outerList.get(j));
                intenalList.add(arr[i]);
                outerList.add(intenalList);
            }
        }
        return outerList;
    }

    public static void main(String[] args) {
        subSeq("", "ab");
    }
}
