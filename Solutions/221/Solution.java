// O(n^2)
class Solution {
    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if(m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        if(n == 0) {
            return 0;
        }
        
        int result = 0;
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i ++) {
            if(matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
            result = Math.max(result, dp[i][0]);
        }
        
        for(int j = 0; j < n; j ++) {
            if(matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
            result = Math.max(result, dp[0][j]);
        }
        
        for(int i = 1; i < m; i ++) {
            for(int j = 1; j < n; j ++) {
                if(matrix[i][j] == '1') {
                    dp[i][j] = 1 + Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1]);   
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result * result;
    }
}