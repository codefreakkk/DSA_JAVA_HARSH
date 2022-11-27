package recursion;

public class Skip {
//    method first by harsh
//    static String skip(StringBuilder str) {
//        String answer = "";
//        if(str.length() == 0) {
//            return "";
//        }
//       answer = skip(new StringBuilder(str.substring(1)));
//        if(str.charAt(0) != 'a') {
//            answer += str.charAt(0);
//        }
//        return  answer;
//    }

//    Kunal's method
    static String skip(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(str.charAt(0) == 'a') {
            return skip(str.substring(1));
        } else {
            return ch + skip(str.substring(1));
        }
    }

//    skip a string
    static String skipString(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(str.startsWith("apple")) {
            return skipString(str.substring(5));
        } else {
            return ch + skipString(str.substring(1));
        }
    }

    static String skipAppNotApple(String str) {
        if(str.isEmpty()) {
            return "";
        }
        char ch = str.charAt(0);
        if(str.startsWith("app") && !str.startsWith("apple")) {
            return skipAppNotApple(str.substring(3));
        } else {
            return ch + skipAppNotApple(str.substring(1));
        }
    }



    // revision
    public static String skipStringApple(String str) {
        if(str.length() == 0) return "";

        char ch = str.charAt(0);
        if(str.startsWith("apple")) {
            return skipStringApple(str.substring(5));
        }
        else return ch + skipStringApple(str.substring(1));
    }

    public static void main(String[] args) {
        System.out.println(skipStringApple("bappleb"));
    }
}
