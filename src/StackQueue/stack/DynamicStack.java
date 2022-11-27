package StackQueue.stack;

public class DynamicStack extends CustomStack {
    public DynamicStack() {
        super();
    }

    public DynamicStack(int size) {
        super(size);
    }

    @Override
    public boolean push(int item) {
        if(isFull()) {
            int[] temp = new int[data.length * 2];

            for(int i = 0; i < data.length; i++) temp[i] = data[i];
            data = temp;
        }

        return super.push(item);
    }

    public static void main(String[] args) throws Exception {
        DynamicStack dstack = new DynamicStack(2);
        dstack.push(10);
        dstack.push(20);
        dstack.push(30);
        System.out.println(dstack.peek());
    }
}
