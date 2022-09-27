package LinkedList.codehelp;

public class AddToNumbersRepresentedByLinkedList {
    public static Node reverse(Node head) {
        Node prev = null;
        Node present = head;
        Node nxt = present.next;

        while(present != null) {
            present.next = prev;
            prev = present;
            present = nxt;
            if(nxt != null) nxt = nxt.next;
        }

        return prev;
    }


    // GFG Solution
    public static Node addTwoList(Node first, Node second) {
        // if both list have only one node present
        if(first.next == null && second.next == null) {
            return new Node(first.value + second.value);
        }

        Node dummy = new Node(-1), temp = dummy;

        Node list1 = reverse(first);
        Node list2 = reverse(second);

        int carry = 0;

        while(list1 != null || list2 != null) {
            int list1Value = 0, list2Value = 0;

            // handle null node values
            if(list1 == null) {
                list1Value = 0;
                list2Value = list2.value;
            }
            else if(list2 == null) {
                list2Value = 0;
                list1Value = list1.value;
            }
            else {
                list1Value = list1.value;
                list2Value = list2.value;
            }

            int sum = list1Value + list2Value + carry;
            int digit = sum % 10;
            carry = sum / 10;

            // update ans linked list
            temp.next = new Node(digit);
            temp = temp.next;

            if(list1 != null) list1 = list1.next;
            if(list2 != null) list2 = list2.next;
        }

        if(carry > 0) temp.next = new Node(carry);
        Node ans = reverse(dummy.next);
        return ans;
    }



    //------- Leetcode solution (some changes has been done according to leetcode's constraints)



//    public ListNode reverse(ListNode head) {
//        ListNode prev = null;
//        ListNode present = head;
//        ListNode nxt = present.next;
//
//        while(present != null) {
//            present.next = prev;
//            prev = present;
//            present = nxt;
//            if(nxt != null) nxt = nxt.next;
//        }
//
//        return prev;
//    }
//
//    public ListNode addTwoNumbers(ListNode first, ListNode second) {
//        // if(first.next == null && second.next == null) {
//        //     return new ListNode(first.val + second.val);
//        // }
//
//        ListNode dummy = new ListNode(-1), temp = dummy;
//
//        // ListNode list1 = reverse(first);
//        // ListNode list2 = reverse(second);
//
//        ListNode list1 = first;
//        ListNode list2 = second;
//
//        int carry = 0;
//
//        while(list1 != null || list2 != null) {
//            int list1Value = 0, list2Value = 0;
//
//            // handle null node values
//            if(list1 == null) {
//                list1Value = 0;
//                list2Value = list2.val;
//            }
//            else if(list2 == null) {
//                list2Value = 0;
//                list1Value = list1.val;
//            }
//            else {
//                list1Value = list1.val;
//                list2Value = list2.val;
//            }
//
//            int sum = list1Value + list2Value + carry;
//            int digit = sum % 10;
//            carry = sum / 10;
//
//            // update ans linked list
//            temp.next = new ListNode(digit);
//            temp = temp.next;
//
//            if(list1 != null) list1 = list1.next;
//            if(list2 != null) list2 = list2.next;
//        }
//
//        if(carry > 0) temp.next = new ListNode(carry);
//        // ListNode ans = reverse(dummy.next);
//        return dummy.next;
//    }



    public static void main(String[] args) {
        SinglyLinkedListCreation s1 = new SinglyLinkedListCreation();
        SinglyLinkedListCreation s2 = new SinglyLinkedListCreation();

        s1.insertLast(2);
        s1.insertLast(4);
        s1.insertLast(9);

        s2.insertLast(5);
        s2.insertLast(6);
        s2.insertLast(4);
        s2.insertLast(9);

        Node head = addTwoList(s1.head, s2.head);
        s1.display(head);
    }
}
