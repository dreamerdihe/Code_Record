// array version
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int range = 0;
        for(int num : nums) {
            range = Math.max(num, range);
        }
        
        int[] count = new int[range + 1];
        int[] dp = new int[range + 1];
        
        for(int num : nums) {
            count[num] ++;
        }
        dp[1] = count[1] == 0? 0 : count[1];
        for(int i = 2; i < range + 1; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
        }
        
        return dp[range];
    }
}
// no dp array version
class Solution {
    public int deleteAndEarn(int[] nums) {
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        int range = 0;
        for(int num : nums) {
            range = Math.max(num, range);
        }
        
        int[] count = new int[range + 1];
        int[] dp = new int[range + 1];
        
        for(int num : nums) {
            count[num] ++;
        }
        dp[1] = count[1] == 0? 0 : count[1];
        for(int i = 2; i < range + 1; i ++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + i * count[i]);
        }
        
        return dp[range];
    }
}