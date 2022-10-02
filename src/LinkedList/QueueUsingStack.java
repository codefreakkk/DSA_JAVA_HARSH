package LinkedList;

public class QueueUsingStack {
    Node front, rear;

    public void enqueue(int a) {
        Node temp = new Node(a);
        if(front == null) {
            front = temp;
            rear = temp;
            return;
        }
        rear.next = temp;
        rear = temp;
    }

    public int dequeue() {
        if(front == null) return -1;

        Node temp = front;
        if(temp != null) {
            temp = temp.next;
            int data = front.value;
            front = temp;
            return data;
        }
        else {
            int data = front.value;
            front = null;
            rear = null;
            return data;
        }
    }

    public static void main(String[] args) {

    }
}
