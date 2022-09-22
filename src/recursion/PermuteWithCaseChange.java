package recursion;

public class PermuteWithCaseChange {
    static void solve(String output, String input) {
        if(input.length() == 0) {
            System.out.println(output);
            return;
        }

        char ch = input.charAt(0);
        solve(output + ch, input.substring(1));
        solve(output + Character.toUpperCase(ch), input.substring(1));
        return;
    }

    static void permute(String str) {
        solve("", str);
    }

    public static void main(String[] args) {
        permute("ab");
    }
}
