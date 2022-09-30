package LinkedList.striver;

public class FlattenALinkedList {
    public static Node merge(Node listA, Node listB) {
       Node list1 = listA.bottom;
       Node list2 = listB;

       Node prev = listA;

       while(list1 != null && list2 != null) {
           if(list2.value >= prev.value && list2.value <= list1.value) {
                Node next = list2.bottom;
                prev.bottom = list2;
                list2.bottom = list1;

                prev = list2;
                list2 = next;
           }
           else {
               prev = list1;
               list1 = list1.bottom;
           }
       }

       if(list2 != null) prev.bottom = list2;
       return listA;
    }

    public static Node solve(Node head) {
        if(head.next == null || head == null) return head;

        Node back = solve(head.next);
        if(head.value <= back.value) {
            return merge(head, back);
        }
        return merge(back, head);
    }

    public static Node flatten(Node head) {
        return solve(head);
    }
    public static void main(String[] args) {

    }
}
