import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    /**
     * BOJ 9095
     * D[N] = n을 1,2,3의 합으로 나타내는 방법의 수
     * 1, 2, 3 올 수 있음
     * N - 1
     * N - 2
     * N - 3
     * D[N] = D[N - 1] + D[N - 2] + D[N - 3]
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] d = new int[11];

        d[0] = 1;
        d[1] = 1;
        d[2] = 2;
        d[3] = 4;

        for (int j = 4; j <= 10; j++) {
            d[j] = d[j - 1] + d[j - 2] + d[j - 3];
        }

        int line = Integer.parseInt(br.readLine());

        for (int i = 0; i < line; i ++) {
            int n = Integer.parseInt(br.readLine());

            System.out.println(d[n]);
        }
    }
}
