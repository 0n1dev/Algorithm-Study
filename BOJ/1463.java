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
        System.out.println(func(n));
    }

    private static int func(int n) {
        // n이 1인 경우 연산 필요 없음
        if (n == 1) return 0;

        // 메모이제이션
        if (d[n] > 0) {
            return d[n];
        }

        // n - 1 일때
        d[n] = func(n - 1) + 1;

        if (n % 2 == 0) {
            int tmp = func(n / 2) + 1;
            if (tmp < d[n]) {
                d[n] = tmp;
            }
        }

        if (n % 3 == 0) {
            int tmp = func(n / 3) + 1;
            if (tmp < d[n]) {
                d[n] = tmp;
            }
        }

        return d[n];
    }
}
