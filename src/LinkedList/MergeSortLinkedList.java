package LinkedList;

import LinkedList.structure.LL;
import LinkedList.structure.Node;

public class MergeSortLinkedList {

    public Node getMid(Node head) {
        // if there is only 1 element than return from here only
        if(head == null || head.next == null) return head;

        Node fast = head;
        Node slow = head;

        while(fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    public Node merge(Node left, Node right) {
        Node l1 = left;
        Node l2 = right;

        Node dummy = new Node(-1);
        Node ans = dummy;

        while(l1 != null && l2 != null) {
            if(l1.value < l2.value) {
                ans.next = l1;
                l1 = l1.next;
            }
            else {
                ans.next = l2;
                l2 = l2.next;
            }
            ans = ans.next;
        }

        // if any one of list is empty
        ans.next = l1 != null ? l1 : l2;

        return dummy.next;
    }

    public Node mergeSort(Node head) {
        if(head == null || head.next == null) return head;

        Node mid = getMid(head);

        // new head i.e -> mid + 1
        Node nHead = mid.next;
        // break connection for dividing list
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(nHead);
        return merge(left, right);
    }

    public Node sortList(Node head) {
        return mergeSort(head);
    }

    public void display(Node head) {
        Node temp = head;

        while(temp != null) {
            System.out.print(temp.value + "->");
            temp = temp.next;
        }
        System.out.println("END");
    }

    public static void main(String[] args) {
        LL list = new LL();
        list.insertLast(4);
        list.insertLast(2);
        list.insertLast(1);
        list.insertLast(3);

        MergeSortLinkedList s = new MergeSortLinkedList();
        s.display(list.head);
        System.out.println();
        Node head = s.sortList(list.head);
        s.display(head);
    }
}
