import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main_10799 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        Stack<Character> stack = new Stack<Character>();

        int sum = 0;
        boolean closeFlag = false;

        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                closeFlag = false; // 바로 닫히면 레이저
            } else {
                if (closeFlag) {
                    stack.pop();
                    sum += 1;
                } else {
                    stack.pop();
                    sum += stack.size();
                }
                closeFlag = true;
            }
        }

        System.out.println(sum);
    }
}