import java.io.*;
import java.util.Stack;

public class Main_9012 {
    /**
     * 괄호
     * https://www.acmicpc.net/problem/9012
     */
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int line = Integer.parseInt(reader.readLine());

        while (line-- > 0) {
            if (vps(reader.readLine())) {
                bw.write("YES\n");
            } else {
                bw.write("NO\n");
            }
        }

        bw.flush();
    }

    public static boolean vps(String str) {
        if (str.length() % 2 != 0) {
            return false;
        }

        Stack<Character> stack = new Stack<Character>();

        char[] charArr = str.toCharArray();
        for (char c : charArr) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.empty()) {
                    return false;
                }
                stack.pop();
            }
        }

        if (stack.empty()) return true;
        return false;
    }
}
