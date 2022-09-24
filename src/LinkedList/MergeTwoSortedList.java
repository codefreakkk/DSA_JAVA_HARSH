package LinkedList;

public class MergeTwoSortedList {

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
