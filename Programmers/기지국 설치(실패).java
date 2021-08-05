import java.util.*;
import java.util.stream.IntStream;

class Solution {

    private static Map<Integer, Integer> aptMap = new HashMap<Integer, Integer>();


    public int solution(int n, int[] stations, int w) {
        int answer = 0;

        IntStream.range(1, n + 1)
                .forEach(i -> aptMap.put(i, 0));

        Arrays.stream(stations)
                .forEach(i -> {
                    aptMap.replace(i, 1);
                });

        for (int i = 1 + w; i <= n; i++) {
            if (aptMap.get(i - w) == 0) {
                addElectron(i - w, w * 2);
                answer++;
            }
        }

        return answer;
    }

    private void addElectron(int start, int length) {
        for (int i = start; i <= start + length; i++) {
            aptMap.replace(i, 1);
        }
    }
}