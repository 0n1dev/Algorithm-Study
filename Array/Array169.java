import java.util.*;

class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        
        int target = 0;;
        int targetCount = 0;
        int maxElement = 0;
        int maxElementCount = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                target = nums[i];
                targetCount++;
            } else {
                if (target != nums[i]) {
                    if (maxElementCount < targetCount) {
                        maxElement = target;
                        maxElementCount = targetCount;
                    }
                    
                    target = nums[i];
                    targetCount = 1;
                } else {
                    targetCount++;
                }
            }
        }
        
        if (targetCount > maxElementCount) {
            return target;
        } else {
            return maxElement;
        }
    }
}