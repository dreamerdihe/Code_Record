// array
public class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+2][n+2];
        for(int j = 2; j < n + 1; j ++) {
            for(int i = j - 1; i > 0; i--) {
                // i - j
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = i; k < j + 1; k ++) {
                    dp[i][j] = Math.min(dp[i][j], k + Math.max(dp[i][k-1], dp[k+1][j]));
                }
            }
        }
        
        return dp[1][n];
    }
}

// memorize
// O(n^3)
class Solution {
    public int getMoneyAmount(int n) {
        int[][] costs = new int[n + 1][n + 1];
        return dp(costs, 1, n);
    }
    
    private int dp(int[][] costs, int start, int end) {
        if(end <= start) {
            return 0;
        }
        
        if(costs[start][end] != 0) {
            return costs[start][end];
        }
        
        int result = Integer.MAX_VALUE;
        for(int i = start; i < end + 1; i ++) {
            result = Math.min(result, i + Math.max(dp(costs, start, i - 1), dp(costs, i + 1, end)));
        }
        
        costs[start][end] = result;
        
        return result;
    }
}