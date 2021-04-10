import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = -1;
        int idx = 0;
        int s1 = 0, s2 = 0;
        int temp;

        PriorityQueue<Integer> q = new PriorityQueue<Integer>(scoville.length);

        for (int e : scoville) {
            q.offer(e);
        }

        while (q.size() > 1) {
            if (q.peek() >= K) {
                answer = idx;
                break;
            }

            s1 = q.poll();
            s2 = q.poll();
            temp = s1 + (s2 * 2);
            q.offer(temp);
            idx++;
        }

        if (q.poll() >= K) {
            answer = idx;
        }

        return answer;
    }
}