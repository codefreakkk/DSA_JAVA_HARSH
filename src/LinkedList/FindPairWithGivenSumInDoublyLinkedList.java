package LinkedList;

import java.util.ArrayList;
import java.util.List;

public class FindPairWithGivenSumInDoublyLinkedList {
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        // traverse till last
        Node left = head;
        Node right = head;
        while(right.next != null) right = right.next;

        while(left != right) {
            if(left.value + right.value < target) left = left.next;
            else if(left.value + right.value > target) right = right.prev;
            else if(left.value + right.value == target) {
                // answer found
                ArrayList<Integer> output = new ArrayList<>();
                output.add(left.value);
                output.add(right.value);
                ans.add(output);
                right = right.prev;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
