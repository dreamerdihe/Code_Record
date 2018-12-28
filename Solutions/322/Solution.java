class Solution {
    public int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, max);
        dp[0] = 0;
        Arrays.sort(coins);
        
        for(int coin : coins) {
            if(coin > amount) {
                break;
            }
            
            dp[coin] = 1;
        }
        
        for(int i = 1; i < amount + 1; i ++) {
            if(dp[i] == 1) {
                continue;
            }
            
            for(int coin : coins) {
                if(coin > i) {
                    break;
                }
                
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        
        return dp[amount] == max? -1: dp[amount];
    }
}