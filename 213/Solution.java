class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } 
        
        if(nums.length == 1) {
            return nums[0];
        }
        
        int[] first = new int[nums.length];
        int[] second = new int[nums.length];
        
        first[1] = nums[0];
        second[1] = nums[1];
        for(int i = 2; i < nums.length; i ++) {
            first[i] = Math.max(nums[i - 1] + first[i - 2], first[i - 1]);
            second[i] = Math.max(nums[i] + second[i - 2], second[i - 1]);
        }
        
        return Math.max(first[nums.length - 1], second[nums.length - 1]);
    }
}