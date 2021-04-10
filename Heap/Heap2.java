class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> m = new HashMap<Integer, Integer>(nums.length);

        for (int num : nums) {
            m.put(num, m.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> list = m.entrySet().stream()
                .sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .map(Map.Entry::getKey).collect(Collectors.toList());
        
        int[] result = new int[k];
        
        for (int i = 0; i < k; i++) {
            result[i] = list.get(i);
        }
        
        return result;
    }
}