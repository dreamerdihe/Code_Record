class Solution {
    public int numIslands(char[][] grid) {
        int result = 0;
        int rows = grid.length;
        if(rows < 1) {
            return result;
        }
        int cols = grid[0].length;
        
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(grid[x][y] == '1') {
                    dfs(x, y, grid);
                    result ++;
                } 
            }
        }
        return result;
        
    }
    
    private void dfs(int x, int y, char[][] grid) {
        if(x < 0 || y < 0 || x > grid.length - 1 || y > grid[x].length - 1 || grid[x][y] == '0') {
            return;
        }
        
        grid[x][y] = '0';
        
        dfs(x-1, y, grid);
        dfs(x+1, y, grid);
        dfs(x, y-1, grid);
        dfs(x, y+1, grid);
    }
}