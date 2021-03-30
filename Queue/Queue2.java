import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int idx = 0;

        Queue<Integer> an = new LinkedList<>();

        while (idx < progresses.length) {
            int compleCount = 0;

            for (int i = idx; i < progresses.length; i++) {
                if (progresses[i] >= 100) {
                    compleCount++;
                    idx++;
                } else {
                    break;
                }
            }

            if (compleCount > 0) {
                an.offer(compleCount);
            }

            for (int i = idx; i < progresses.length; i++) {
                progresses[i] += speeds[i];
            }
        }
        int[] answer = new int[an.size()];

        for (int i = 0; i < answer.length; i++) {
            answer[i] = an.poll();
        }
        
        return answer;
    }
}