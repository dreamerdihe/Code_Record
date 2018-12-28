class Solution {
    public int longestPalindromeSubseq(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int[][] dp = new int[s.length()][s.length()];
        
        for(int i = 0; i < s.length(); i ++) {
            dp[i][i] = 1;
        }
        
        for(int j = 0; j < s.length(); j ++) {
            // i ~ j
            for(int i = j - 1; i > -1; i --) {
                if(s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        
        return dp[0][s.length()-1];
    }
}