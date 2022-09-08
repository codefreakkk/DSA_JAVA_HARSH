package StackQueue;

class TwoStack
{

    int size;
    int top1,top2;
    int arr[] = new int[100];

    TwoStack()
    {
        size = 100;
        top1 = -1;
        top2 = size;
    }
}

public class TwoStackInOneArray {

    void push1(int x, TwoStack sq)
    {
       sq.top1++;
       sq.arr[sq.top1] = x;
    }

    //Function to push an integer into the stack2.
    void push2(int x, TwoStack sq)
    {
        sq.top2--;
        sq.arr[sq.top2] = x;
    }

    //Function to remove an element from top of the stack1.
    int pop1(TwoStack sq)
    {
        if(sq.top1 == -1) return -1;
        return sq.arr[sq.top1--];
    }

    //Function to remove an element from top of the stack2.
    int pop2(TwoStack sq)
    {
        if(sq.top2 == sq.size) return -1;
        return sq.arr[sq.top2++];
    }

    public static void main(String[] args) {
        TwoStackInOneArray o = new TwoStackInOneArray();
        TwoStack obj = new TwoStack();
        o.push1(2, obj);
        o.push1(3, obj);
        o.push2(4, obj);
        System.out.println(o.pop1(obj));
        System.out.println(o.pop2(obj));
        System.out.println(o.pop2(obj));
    }
}
