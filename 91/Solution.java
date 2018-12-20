class Solution {
    public int numDecodings(String s) {
        if(s.length() < 1) {
            return 0;
        }
        
        int dp[] = new int[s.length() + 1];
        dp[0] = 1;
        for(int i = 0; i < s.length(); i ++) {
            if(s.charAt(i) != '0') {
                dp[i + 1] = dp[i];    
            }
            if(i > 0 && s.charAt(i - 1) != '0' && Integer.parseInt(s.substring(i-1, i+1)) < 27) {
                dp[i + 1] += dp[i - 1];
            }
        }
        
        return dp[s.length()];
    }
}