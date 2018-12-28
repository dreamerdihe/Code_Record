// version DP

class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2; i < n + 1; i ++) {
            for(int j = 1; j < i; j ++) {
                dp[i] = Math.max(Math.max(dp[j], j) * Math.max(dp[i - j], i - j), dp[i]);
            }
        }
        System.out.println(Arrays.toString(dp));
        return dp[n];
    }
}
// version Math

class Solution {
    public int integerBreak(int n) {
        if(n < 3) {
            return 1;
        }
        
        if(n == 3) {
            return 2;
        }
        
        if(n % 3 == 0) {
            return (int)Math.pow(3, n / 3);
        }
        
        if(n % 3 == 1) {
            return (int)Math.pow(3, (n - 4) / 3) * 4;
        }
        
        if(n % 3 == 2) {
            return (int)Math.pow(3, (n - 2) / 3) * 2;
         }
        
        return 1;
    }
}