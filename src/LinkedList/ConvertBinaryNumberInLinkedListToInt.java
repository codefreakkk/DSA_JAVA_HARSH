package LinkedList;

public class ConvertBinaryNumberInLinkedListToInt {
    public static int convertBinaryToDecimal(String str) {
        int decimal = 0;
        int base = 1;
        int size = str.length();

        for(int i = size - 1; i >= 0; i--) {
            if(str.charAt(i) == '1') decimal += base;
            base *= 2;
        }

        return decimal;
    }

    public static int getDecimalValues(Node head) {
        // convert list numbers into string
        Node temp = head;
        String str = "";

        while(temp != null) {
            str += temp.value + "";
            temp = temp.next;
        }

        int ans = convertBinaryToDecimal(str);
        return ans;
    }

    public static void main(String[] args) {

    }
}
