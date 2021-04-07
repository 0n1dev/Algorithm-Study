import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
* 스택 문제
* https://www.acmicpc.net/submit/10828/28113561
*/

public class Main {
    static int[] stack;
    static int idx;

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            int n = Integer.parseInt(reader.readLine());

            stack = new int[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(reader.readLine(), " ");

                String command = st.nextToken();

                int result = 0;

                switch (command) {
                    case "push" :
                        push(Integer.parseInt(st.nextToken()));
                        break;
                    case "pop" :
                        result = pop();
                        System.out.println(result);
                        break;
                    case "size" :
                        result = size();
                        System.out.println(result);
                        break;
                    case "empty" :
                        result = empty();
                        System.out.println(result);
                        break;
                    case "top" :
                        result = top();
                        System.out.println(result);
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int push(int v) {
        stack[idx++] = v;
        return v;
    }

    public static int pop() {
        if (idx == 0) {
            return -1;
        }

        return stack[--idx];
    }

    public static int size() {
        return idx;
    }

    public static int empty() {
        return idx == 0 ? 1 : 0;
    }

    public static int top() {
        return idx == 0 ? -1 : stack[idx - 1];
    }
}
