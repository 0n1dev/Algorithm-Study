/**
 * 테스트 케이스 통과 
 * 제출시 통과 못함...? 왜일까?
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

class Solution {

    class Node {
        private String referral;
        private int amount;

        public Node(String referral) {
            this.referral = referral;
            this.amount = 0;
        }

        public String getReferral() {
            return referral;
        }

        public int getAmount() {
            return amount;
        }

        public void addAmount(int amount) {
            this.amount += amount;
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer = new int[enroll.length];
        Map<String, Node> m = new HashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            m.put(enroll[i], new Node(referral[i]));
        }

        for (int i = 0; i < seller.length; i++) {
            String nextKey = seller[i];
            int a = amount[i] * 100;
            while (m.containsKey(nextKey)) {

                Node n = m.get(nextKey);

                if (a < 10) {
                    n.addAmount(a);
                } else {
                    int a2 = (int) Math.floor(a * 0.1);
                    n.addAmount(a - a2);
                    a = a2;
                }

                nextKey = n.getReferral();
            }
        }

        for (int i = 0; i < enroll.length; i++) {
            answer[i] = m.get(enroll[i]).getAmount();
        }

        return answer;
    }
}