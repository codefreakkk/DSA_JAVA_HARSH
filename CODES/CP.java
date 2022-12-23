
import java.util.*;
import java.io.*;

public class CP {
    static class FastReader{
        BufferedReader br;
        StringTokenizer st;
        public FastReader(){
            br=new BufferedReader(new InputStreamReader(System.in));
        }
        String next(){
            while(st==null || !st.hasMoreTokens()){
                try {
                    st=new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            
            return st.nextToken();
        }
        int nextInt(){
            return Integer.parseInt(next());
        }
        long nextLong(){
            return Long.parseLong(next());
        }
        double nextDouble(){
            return Double.parseDouble(next());
        }
        String nextLine(){
            String str="";
            try {
                str=br.readLine().trim();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return str;
        }
    }
    static class FastWriter {
        private final BufferedWriter bw;

        public FastWriter() {
            this.bw = new BufferedWriter(new OutputStreamWriter(System.out));
        }

        public void print(Object object) throws IOException {
            bw.append("" + object);
        }

        public void println(Object object) throws IOException {
            print(object);
            bw.append("\n");
        }

        public void close() throws IOException {
            bw.close();
        }
    }

    public static void main(String[] args) throws IOException, Exception {
        try {
            FastReader in=new FastReader();
            FastWriter out = new FastWriter();

            // code here

            //            int t=in.nextInt();
//            while(t-- > 0) {}

            String s = in.nextLine();

            Stack<Character> stack = new Stack<>();
            int size = s.length();
            int cnt = 0, occur = 1, max = Integer.MIN_VALUE;

            for(int i = 0; i < size; i++) {
                char ch = s.charAt(i);
                if(ch == '(') {
                    stack.push(ch);
                    cnt = 0;
                }
                else {
                    if(!stack.isEmpty() && ch == ')') {
                       if(stack.peek() == '(') {
                           stack.pop();
                           cnt++;
                       }
                    }
                }
                if(stack.isEmpty()) cnt = 0;
            }

            out.print(max);
            out.print(" " + occur);
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }
}



