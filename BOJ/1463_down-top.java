import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463 {
    private static int[] d;
    /**
     * BOJ 1463
     * D[N] = N을 1로 만드는 최소 연산 횟수
     * N -> N/3 단계 1
     * N -> N/2 단계 2
     * N -> N - 1 단계 3
     * D[N] = min( D[N/3], D[N/2], D[N-1] )
     * */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        d = new int[n + 1];
        d[1] = 0;

        for (int i = 2; i <= n; i++) {
            d[i] = d[i - 1] + 1;
            if (i % 2 == 0 && d[i] > d[i/2] + 1) {
                d[i] = d[i/2] + 1;
            }

            if (i % 3 == 0 && d[i] > d[i/3] + 1) {
                d[i] = d[i/3] + 1;
            }
        }

        System.out.println(d[n]);
    }
}
