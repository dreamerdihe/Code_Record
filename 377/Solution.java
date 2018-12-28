// dp
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i ++) {
            for(int num : nums) {
                if(i - num >=0) {
                    dp[i] += dp[i - num];
                }
            }
        }
        
        return dp[target];
    }
}

// memorize
class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] memo = new int[target + 1];
        Arrays.fill(memo, -1);
        memo[0] = 1;
        
        return helper(nums, memo, target);
    }
    
    private int helper(int[] nums, int[] memo, int target) {
        int result = 0;
        
        if(target < 0) {
            return 0;
        }
        
        if(memo[target] != -1) {
            return memo[target];
        }
        
        for(int num : nums) {
            result += helper(nums, memo, target - num);
        }
        
        memo[target] = result;
        return result;
    }
}