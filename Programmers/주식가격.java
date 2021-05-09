/**
 * http://www.yes24.com/Product/Goods/83849117
 */


public class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {

            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i] = j - i;
                    break;
                }
                if (j == answer.length-1) {
                    answer[i] = j - i;
                }
            }
        }

        return answer;
    }
}