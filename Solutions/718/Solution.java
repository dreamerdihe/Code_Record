// O(m * n)
class Solution {
    public int findLength(int[] A, int[] B) {
        if(A.length == 0 || B.length == 0) {
            return 0;
        }
        int[][] dp = new int[A.length + 1][B.length + 1];
        // dp[i][j] = answer for A[i:] and B[j:]
        
        int result = 0;
        for(int i = A.length - 1; i > -1; i --) {
            for(int j = B.length - 1; j > -1; j --) {
                if(A[i] == B[j]) {
                    dp[i][j] = dp[i + 1][j + 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        
        return result;
    }
}