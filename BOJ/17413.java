import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_17413 {
    /**
     * 단어 뒤집기2
     * https://www.acmicpc.net/problem/17413
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<Character>();
        boolean tagFlag = false;

        String str = br.readLine();

        for (char c : str.toCharArray()) {
            if (tagFlag) {
                if (c == '>') {
                    sb.append(c);
                    tagFlag = false;
                } else {
                    sb.append(c);
                }
            } else {
                if (c == '<') {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }

                    sb.append(c);
                    tagFlag = true;
                } else if (c == ' ') {
                    while (!stack.empty()) {
                        sb.append(stack.pop());
                    }
                    sb.append(c);
                } else {
                    stack.push(c);
                }
            }
        }

        while (!stack.empty()) {
            sb.append(stack.pop());
        }

        System.out.println(sb);
    }
}