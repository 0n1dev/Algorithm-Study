import java.util.*;

class Solution {

    public String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();

        for (String p : participant) {
            map.put(p, map.getOrDefault(p, 0) + 1);
        }

        for(String c : completion) {
            Integer value = map.get(c);

            if (value == 1) {
                map.remove(c);
            } else {
                map.put(c, --value);
            }
        }

        return map.keySet().toArray(String[]::new)[0];
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};
        System.out.println(s.solution(participant, completion));
    }
}