package REVISION.recursion;

public class PrintTriangleRecursion {
    public static void print(int row, int col) {
        if(row == 0) return;

        if(col < row)  {
            System.out.print("*");
            print(row, col + 1);
        }
        else {
            System.out.println();
            print(row - 1, 0);
        }
    }
    public static void main(String[] args) {
        print(4, 0);
    }
}
