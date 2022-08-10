package recursion;

public class KthSymbolInGrammerLeetocode {


//    This solution will not work because of TLE

//    public static String getCompliment(String answer) {
////        get the string and get the one's compliment of the String
//        String comp = "";
//        for(int i = 0; i < answer.length(); i++) {
//            if(answer.charAt(i) == '0') comp += '1';
//            else comp += '0';
//        }
//        return comp;
//    }
//
//    public static int solve(int n, int k, String answer, int index) {
//        if(index == n - 1) {
//            // convert '1' or '0' to 1 or 0, convert acutall char value to actuall int value
//            return answer.charAt(k - 1) - '0';
//        }
//        String compliment = getCompliment(answer);
//        return solve(n, k, answer + compliment, index + 1);
//    }
//
//    public static int kthGrammer(int n, int k) {
//        return solve(n, k, "0", 0);
//    }

    static int kthGrammar(int n, int k) {
        if(n == 1 && k == 1) {
            return 0;
        }
        int mid = (int) Math.pow(2, n - 1);

        if(k <= mid) return kthGrammar(n - 1, k);
        else return kthGrammar(n - 1, k - mid) ^ 1;
    }

    public static void main(String[] args) {
        System.out.println(kthGrammar(3, 1));
    }
}
