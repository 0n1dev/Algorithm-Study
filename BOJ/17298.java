// 시간 초과 for문이 돌면서 O(n)이 초과될텐데 그 안에서 재귀적으로 한번더 돌기 때문에 O(n)이 넘어서는것 같다. 내일 수정해보기
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_17298 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int count = Integer.parseInt(br.readLine());
        ArrayList<Integer> a1 = new ArrayList<Integer>(count);

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < count; i++) {
            a1.add(Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < a1.size() - 1; i++) {
            bw.write(Integer.toString(maxLeftValue(a1, i, i + 1, a1.size() - 1)) + " ");
        }
        bw.write("-1");
        bw.flush();
    }

    public static int maxLeftValue(ArrayList<Integer> a1, int targetIdx, int compareIdx, int count) {
        if (a1.get(targetIdx) < a1.get(compareIdx)) {
            return a1.get(compareIdx);
        } else {
            if (compareIdx == count) {
                return -1;
            } else {
                return maxLeftValue(a1, targetIdx, compareIdx + 1, count);
            }
        }
    }
}
