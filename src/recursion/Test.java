package recursion;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static int add(int n) {
        if(n == 0) {
            return 0;
        }
        return n + add(n - 1);
    }

    static void testSubstring() {
        String str = "fgapples";
        System.out.println(str.substring(2, 7));
    }
    static void compareTwoList() {
//        List<Integer> l1 = new ArrayList<>();
//        l1.add(1);
//        l1.add(2);
//        List<Integer> l2 = new ArrayList<>();
//        l2.add(1);
//        l2.add(22);
//        if(l1.equals(l2) == true) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }
        int arr[][] = {{1, 2, 3},
                {1, 2, 4}};
        System.out.println(arr.length);
    }

    public static void main(String[] args) {
//        System.out.println(add(5));
//        testSubstring();
//        compareTwoList();
//        int a = 10;
//        char a = '9';
//        System.out.println(a == (char) (9 + '0'));
//        char ch = ':';
//        System.out.println(Character.isLetterOrDigit(ch));
//        boolean[] a = new boolean[6];
//        System.out.println(a[1]);

//        String s = "harshsachinsaid";
//        System.out.println(s.startsWith("harsh"));

//        System.out.println(4 >> 3);
//        int num = 4;
//        int count = 0;
//        while(num > 0) {
//            num = num >> 1;
//            count++;
//        }
//        System.out.println(count -1);

    }

}
