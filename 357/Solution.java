class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i < n + 1; i ++) {
            dp[i] = 9 * fact(i - 1);
        }
        
        int result = 0;
        for(int res : dp) {
            result += res;
        }
        return result;
    }
    
    private int fact(int n) {        
        int res = 1;
        for(int i = 0; i < n; i ++) {
            res *= (9 - i);
        }
        
        return res;
    }
}