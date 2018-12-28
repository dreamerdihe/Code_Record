class Solution {
    private int n;
    private int m;
    private int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        m = matrix.length;
        n = matrix[0].length;
        
        boolean[][] A = new boolean[m][n];
        boolean[][] P = new boolean[m][n];
        for(int x = 0; x < m; x ++) {
            dfs(matrix, x, n - 1, A, Integer.MIN_VALUE);
            dfs(matrix, x, 0, P, Integer.MIN_VALUE);
        }
        
        for(int y = 0; y < n; y ++) {
            dfs(matrix, 0, y, P, Integer.MIN_VALUE);
            dfs(matrix, m - 1, y, A, Integer.MIN_VALUE);
        }
        
        for(int i = 0; i < m; i ++) {
            for(int j = 0; j < n; j ++) {
                if(A[i][j] && P[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        
        return result;
        
    }
    
    private void dfs(int[][] matrix, int x, int y, boolean[][] canFlow, int last) {
        if(x < 0 || x > m - 1 || y < 0 || y > n - 1 || canFlow[x][y]) {
            return;
        }
        
        if(last <= matrix[x][y]) {
            canFlow[x][y] = true;
        } else {
            return;
        }
                
    
        dfs(matrix, x + 1, y, canFlow, matrix[x][y]);
        dfs(matrix, x - 1, y, canFlow, matrix[x][y]);
        dfs(matrix, x, y + 1, canFlow, matrix[x][y]);
        dfs(matrix, x, y - 1, canFlow, matrix[x][y]);
    }
}