package LinkedList;

public class MergeKSortedList {

    public static Node merge(Node list1, Node list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.value <= list2.value) {
            list1.next = merge(list1.next, list2);
            return list1;
        }
        else {
            list2.next = merge(list1, list2.next);
            return list2;
        }
    }

    public static Node solve(Node[] head, int start, int end) {
        if(start == end) return head[start];
        if(start < end) {
            int mid = start + (end - start) / 2;
            Node left = solve(head, start, mid);
            Node right = solve(head, mid + 1, end);
            return merge(left, right);
        }
        return null;
    }

    public static Node mergeKLists(Node[] head) {
        if(head == null) return null;
        if(head[0] == null) return head[0];

        return solve(head, 0, head.length - 1);
    }

    public static void main(String[] args) {

    }
}
