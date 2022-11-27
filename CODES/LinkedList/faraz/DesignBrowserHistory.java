package LinkedList.faraz;

import java.util.*;

class ListNode {
    protected String val;
    ListNode prev, next;

    public ListNode(String val) {
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

public class DesignBrowserHistory {

    ListNode current;
    public DesignBrowserHistory(String homepage) {
        ListNode head = new ListNode(homepage);
        current = head;
    }

    public void visit(String url) {
        ListNode temp = new ListNode(url);
        temp.prev = current;
        current.next = temp;
        current = current.next;
    }

    public String back(int steps) {
        while(current.prev != null && steps-- > 0) {
            current = current.prev;
        }

        return current.val;
    }

    public String forward(int steps) {
        while(current.next != null && steps-- > 0) {
            current = current.next;
        }

        return current.val;
    }

    public static void main(String[] args) {

    }
}
