import java.util.*;

class Solution {

    private Map<String, Integer> maps = new HashMap<>();

    public int solution(String[][] clothes) {
        int answer = 0;

        Arrays.stream(clothes)
                        .forEach(v -> {
                            maps.put(v[1], maps.getOrDefault(v[1], 0) + 1);
                        });

        Integer value = Arrays.stream(maps.values().toArray(new Integer[0]))
                .reduce(1, (e1, e2) -> e1 * e2);

        if (maps.size() == 1) {
            value = 0;
        }

        return answer + value;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(s.solution(clothes));

    }
}