import java.io.*;
import java.util.Stack;

/**
* 스택 문제
* https://www.acmicpc.net/problem/9093
*/

public class Main_9093 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // print 보다 속도가 빠름 (print로 하면 속도 느려짐)

        int line = Integer.parseInt(reader.readLine());

        for (int i = 0; i < line; i++) {
            String str = reader.readLine() + "\n";

            Stack<Character> stack = new Stack<>();

            for (char c : str.toCharArray()) {
                if (c == '\n' || c == ' ') {
                    while (!stack.empty()) {
                        bw.write(stack.pop());
                    }

                    bw.write(c);
                } else {
                    stack.push(c);
                }
            }
        }
        bw.flush();
    }
}
