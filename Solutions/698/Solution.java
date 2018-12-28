class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        
        if(sum % k != 0) {
            return false;
        }
        
        int target = sum / k;
        
        boolean[] visited = new boolean[nums.length];
        
        return helper(nums, visited, target, target, k, 0);
    }
    
    private boolean helper(int[] nums, boolean[] visited, int target, int res, int k, int start) {
        if(k == 1) {
            return true;
        }
        
        if(res < 0) {
            return false;
        }
        
        if(res == 0) {
            return helper(nums, visited, target, target, k - 1, 0);
        }
        
        
        
        for(int i = start; i < nums.length; i ++) {
            if(!visited[i]) {
               visited[i] = true;
                if(helper(nums, visited, target, res - nums[i], k, i + 1)) {
                    return true;
                }
                visited[i] = false;
            }
            
        }
        
        return false;
    }
}