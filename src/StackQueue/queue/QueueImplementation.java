package StackQueue.queue;

public class QueueImplementation {
    int[] arr;
    int size;
    int front = 0;
    int rear = 0;

    public QueueImplementation() {
        arr = new int[5];
        size = arr.length;
    }

    public boolean isEmpty() {
        if(front == rear) return true;
        return false;
    }

    public void push(int x) {
        if(rear == size) System.out.println("Queue full");
        else {
            arr[rear] = x;
            rear++;
        }
    }

    public int pop() {
        if(isEmpty()) return -1;

        int value = arr[front];
        arr[front] = -1;
        front++;

        if(front == rear) {
            front = 0;
            rear = 0;
        }

        return value;
    }

    public static void main(String[] args) {
        QueueImplementation queue = new QueueImplementation();
        queue.push(10);
        queue.push(20);
        queue.push(30);

        System.out.println(queue.pop());
    }
}
