import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        Arrays.sort(nums);
        List<Integer> l = new ArrayList<>();
        
        if (nums.length <= 0) {
            return l;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (Arrays.binarySearch(nums, i + 1) < 0) {
                l.add(i + 1);
            }
        }
        
        return l;
    }
}