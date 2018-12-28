class Solution {
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows < 1) {
            return;
        }
        int cols = board[0].length;
        for(int x = 0; x < rows; x++) {
            if(board[x][0] == 'O') {
                dfs(x, 0, board);
            }            
        }
        
        if(cols > 1) {
            for(int x = 0; x < rows; x++) {
                if(board[x][cols - 1] == 'O') {
                    dfs(x, cols - 1, board);
                }
            }
        }
        
        for(int y = 0; y < cols; y++) {
            if(board[0][y] == 'O') {
                dfs(0, y, board);
            }
        }
        
        if(rows > 1) {
            for(int y = 0; y < cols; y++) {
                if(board[rows - 1][y] == 'O')
                dfs(rows - 1, y, board);
            }
        }
        
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(board[x][y] == 'O') {
                    board[x][y] = 'X';
                }
                
                if(board[x][y] == 'C') {
                    board[x][y] = 'O';
                }
            }
        }
    }
    
    private void dfs(int x, int y, char[][] board) {
        if(x < 0 || y < 0 || x > board.length - 1 || y > board[x].length - 1 || board[x][y] == 'X' || board[x][y] == 'C') {
            return;
        }
        
        board[x][y] = 'C';
        
        dfs(x - 1, y, board);
        dfs(x + 1, y, board);
        dfs(x, y - 1, board);
        dfs(x, y + 1, board);
    }
}