class Solution {
    public void moveZeroes(int[] nums) {
        int temp;
        int idx = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            if (idx == nums.length) {
                break;
            }
            
            if (nums[i] == 0) {
                temp = nums[i];
                
                for (int j = i; j < nums.length - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                
                nums[nums.length - 1] = temp;
                
                i--;
                idx++;
            }
        }
    }
}