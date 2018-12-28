class Solution {
    public int nthUglyNumber(int n) {
        int[] dp = new int[n];
        dp[0] = 1;
        int fact2 = 0;
        int fact3 = 0;
        int fact5 = 0;
        int i = 1;
        while(i < n) {
            int cand2 = dp[fact2] * 2;
            int cand3 = dp[fact3] * 3;
            int cand5 = dp[fact5] * 5;
            
            if(cand2 <= cand3 && cand2 <= cand5) {
                fact2 ++;
                if(dp[i - 1] == cand2) {
                    continue;
                }
                dp[i] = cand2;
            } else if(cand3 <= cand2 && cand3 <= cand5) {
                fact3 ++;
                if(dp[i - 1] == cand3) {
                    continue;
                }
                dp[i] = cand3;
            } else {
                fact5 ++;
                if(dp[i - 1] == cand5) {
                    continue;
                }
                dp[i] = cand5;
            }
            
            i ++;
        }
        
        // System.out.println(Arrays.toString(dp));
        return dp[n - 1];
    }
}