import java.util.*;

class Solution {
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // matrix 초기화
        int[][] matrix = new int[rows][columns];
        int idx = 1;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = idx++;
            }
        }

        // matrix query 실행
        int cnt = 0;
        for (int[] query : queries) {
            pq.clear();

            int height = query[2] - query[0];
            int width = query[3] - query[1];

            int num = matrix[query[0] - 1][query[1] - 1];
            pq.add(num);

            // 오른쪽
            for (int i = 1; i < width; i++) {
                int tmp = matrix[query[0] - 1][query[1] + i - 1];
                matrix[query[0] - 1][query[1] + i - 1] = num;
                num = tmp;
                pq.add(num);
            }

            // 아래쪽
            for (int i = 0; i < height; i++) {
                int tmp = matrix[query[0] + i - 1][query[1] + width - 1];
                matrix[query[0] + i - 1][query[1] + width - 1] = num;
                num = tmp;
                pq.add(num);
            }

            // 왼쪽
            for (int i = width; i > 0; i--) {
                int tmp = matrix[query[0] + height - 1][query[1] + i - 1];
                matrix[query[0] + height - 1][query[1] + i - 1] = num;
                num = tmp;
                pq.add(num);
            }

            // 윗쪽
            for (int i = height; i >= 0; i--) {
                int tmp = matrix[query[0] + i - 1][query[1] - 1];
                matrix[query[0] + i - 1][query[1] - 1] = num;
                num = tmp;
                pq.add(num);
            }

            answer[cnt++] = pq.poll();
        }

        return answer;
    }
}