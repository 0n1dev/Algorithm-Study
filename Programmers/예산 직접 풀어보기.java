import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public static void main(String[] args) {

        Solution s  = new Solution();
        int[] budgets  = {120, 110, 140, 150};

        System.out.println(s.solution(budgets, 485));

    }

    public int solution(int[] budgets, int M) {
        int answer = 0;

        int min = 0;
        int max = IntStream.of(budgets).max().orElse(0);

        while (min <= max) {
            int mid = (min + max) / 2;

            int sum = IntStream.of(budgets)
                    .map(budget -> Math.min(budget, mid))
                    .sum();

            if (sum <= M) {
                min = mid + 1;
                answer = mid;
            } else {
                max = mid - 1;
            }
        }

        return answer;
    }
}