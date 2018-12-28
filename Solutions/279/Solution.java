class Solution {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= (int)Math.sqrt(n); i ++) {
            dp[i * i] = 1;
        }
            
        for(int i = 1; i < n + 1; i ++) {
            if(dp[i] == 1) {
                continue;
            }
            int j = 1;
            while(j * j < i) {
                dp[i] = Math.min(dp[i], 1 + dp[i - j * j]);
                j ++;
            }
        }
        return dp[n];
    }
}