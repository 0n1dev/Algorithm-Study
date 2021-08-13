import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {

        Solution s  = new Solution();
        int[] A = {5,5,5,5};
        int[] B = {2,2,6,8};

        System.out.println(s.solution(A, B));

    }

    private Queue<Integer> aQueue;
    private Queue<Integer> bQueue;

    public int solution(int[] A, int[] B) {
        int answer = 0;

        aQueue = IntStream.of(A)
                        .boxed()
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toCollection(LinkedList<Integer>::new));

        bQueue = IntStream.of(B)
                        .boxed()
                        .sorted(Collections.reverseOrder())
                        .collect(Collectors.toCollection(LinkedList<Integer>::new));

        while (!bQueue.isEmpty()) {
            Integer b = bQueue.poll();

            if (isWin(b)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isWin(Integer v) {
        while (!aQueue.isEmpty()) {
            Integer a = aQueue.poll();

            if (v > a) {
                return true;
            }
        }
        return false;
    }
}