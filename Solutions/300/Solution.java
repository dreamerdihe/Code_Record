// O(n^2) version
class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        
        for(int i = 1; i < dp.length; i ++) {
            dp[i] = 1;
            for(int j = i - 1; j > -1; j --) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        return max(dp);
    }
    
    private int max(int[] dp) {
        int max = Integer.MIN_VALUE;
        for(int num : dp) {
            max = Math.max(max, num);
        }
        
        return max;
    }
}

// O(nlogn) version
// too hard