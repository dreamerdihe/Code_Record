class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        
        int max = nums[0];
        int min = nums[0];
        int result = max;
            
        for(int i = 1; i < nums.length; i ++) {
            int tmax = max * nums[i];
            int tmin = min * nums[i];
            max = Math.max(Math.max(tmax, nums[i]), tmin);
            min = Math.min(Math.min(tmax, nums[i]), tmin);
            result = Math.max(max, result);
        }
        
        return result;
    }
}