package StackQueue;

public class DynamicQueue extends CircularQueue {

    public DynamicQueue() {
        super();
    }

    public DynamicQueue(int size) {
        super(size);
    }

    @Override
    public boolean insert(int item) {
        if(isFull()) {
            int[] temp = new int[data.length * 2];
            for(int i = 0; i < data.length; i++) {
                temp[i] = data[(front + i) % data.length];
            }
            front = 0;
            back = data.length;
            data = temp;
        }
        super.insert(item);
        return true;
    }

    public static void main(String[] args) {
        DynamicQueue dqueue = new DynamicQueue(2);
        dqueue.insert(10);
        dqueue.insert(20);
        dqueue.insert(30);
        dqueue.display();
    }
}
