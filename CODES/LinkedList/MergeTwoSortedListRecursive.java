package LinkedList;

public class MergeTwoSortedListRecursive {
    public static Node mergeTwoSortedList(Node list1, Node list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        if(list1.value <= list2.value) {
            list1.next = mergeTwoSortedList(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoSortedList(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {

    }
}
