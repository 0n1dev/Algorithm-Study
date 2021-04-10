import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        ArrayList<Integer> list = new ArrayList<Integer>();

        int[] answer = new int[2];
        for (String cmd : operations) {
            String[] oper = cmd.split(" ");

            switch(oper[0]) {
                case "I":
                    list.add(Integer.parseInt(oper[1]));
                    list.sort(new Comparator<Integer>() {

                        @Override
                        public int compare(Integer o1, Integer o2) {
                            return o1 - o2;
                        }
                    });
                    break;
                case "D":
                    if (list.isEmpty()) {
                        break;
                    }

                    if (Integer.parseInt(oper[1]) == 1) {
                        list.remove(list.size() - 1);
                    } else {
                        list.remove(0);
                    }
            }
        }

        if (list.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        } else {
            answer[0] = list.get(list.size() - 1);
            answer[1] = list.get(0);
        }
        return answer;
    }
}