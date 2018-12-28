class Solution {
    public int rob(int[] nums) {
        int result = 0;
        
        if(nums.length == 0) {
            return result;
        }
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int ending = nums[0];
        int notEnding = 0;
        
        for(int i = 1; i < nums.length ; i++) {
            result = Math.max(ending, notEnding + nums[i]);
            notEnding = ending;
            ending = result;
        }
        
        return result;
    }
}