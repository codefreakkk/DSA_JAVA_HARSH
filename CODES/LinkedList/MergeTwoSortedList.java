package LinkedList;

public class MergeTwoSortedList {

    // using an extra dummy node
    public SinglyLinkedListCreation mergeTwoList(SinglyLinkedListCreation first, SinglyLinkedListCreation second) {
        Node f = first.head;
        Node s = second.head;

        SinglyLinkedListCreation ans = new SinglyLinkedListCreation();

        while(f != null && s != null) {
            if(f.value < s.value) {
                ans.insertLast(f.value);
                f = f.next;
            }
            else {
                ans.insertLast(s.value);
                s = s.next;
            }
        }

        while(f != null) {
            ans.insertLast(f.value);
            f = f.next;
        }

        while(s != null) {
            ans.insertLast(s.value);
            s = s.next;
        }

        return ans;
    }


    // without using any extra dummy node (inplace merging)
//    public static LinkedList.codehelp.Node solve(LinkedList.codehelp.Node list1, LinkedList.codehelp.Node list2) {
//        LinkedList.codehelp.Node prev = list1;
//        LinkedList.codehelp.Node current = list1.next;
//        LinkedList.codehelp.Node list2Current = list2;
//        LinkedList.codehelp.Node next2 = null;
//
//        while(current != null && list2Current != null) {
//            if(list2Current.value >= prev.value && list2Current.value <= current.value) {
//                // make new connections
//                prev.next = list2Current;
//                next2 = list2Current.next;
//                list2Current.next = current;
//
//                // update the pointers
//                prev = list2Current;
//                list2Current = next2;
//            }
//            else {
//                prev = current;
//                current = current.next;
//            }
//        }
//
//        if(list2Current != null) prev.next = list2Current;
//        return list1;
//    }
//
//    public static LinkedList.codehelp.Node mergeTwoList(LinkedList.codehelp.Node list1, LinkedList.codehelp.Node list2) {
//        if(list1 == null) return list2;
//        if(list2 == null) return list1;
//
//        if(list1.value <= list2.value) {
//            return solve(list1, list2);
//        }
//        return solve(list2, list1);
//    }

    public static void main(String[] args) {
        SinglyLinkedListCreation first = new SinglyLinkedListCreation();
        first.insertLast(1);
        first.insertLast(2);
        first.insertLast(4);
        SinglyLinkedListCreation second = new SinglyLinkedListCreation();
        second.insertLast(1);
        second.insertLast(3);
        second.insertLast(4);

        MergeTwoSortedList object = new MergeTwoSortedList();
        SinglyLinkedListCreation ans = object.mergeTwoList(first, second);
        ans.display();
    }

}
