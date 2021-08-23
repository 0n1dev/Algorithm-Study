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
                .reduce(1, (e1, e2) -> e1 * (e2 + 1));
        
        

        return value - 1;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        String[][] clothes = {{"crowmask", "face"}, {"bluesunglasses", "face"}, {"smoky_makeup", "face"}};

        System.out.println(s.solution(clothes));

    }
}

---

// 스트림 없이

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new LinkedHashMap<>();

        for (String[] c : clothes) {
            map.put(c[1], map.getOrDefault(c[1], 0) + 1);
        }

        Set<String> keys = map.keySet();

        for (String key : keys) {
            answer *= (map.get(key) + 1);
        }

        return answer - 1;
    }