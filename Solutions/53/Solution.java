class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int ending = nums[0];
        
        for(int i = 1; i < nums.length; i ++) {
            ending = Math.max(ending + nums[i], nums[i]);
            max = Math.max(max, ending);
        }
        
        return max;
    }
}