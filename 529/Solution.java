class Solution {
    private int[] dx = {1, -1, 0 ,0, 1, 1, -1, -1};
    private int[] dy = {0, 0, 1 ,-1, 1, -1, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        int i = click[0];
        int j = click[1];
        
        if(board[i][j] == 'M') {
            board[i][j] = 'X';
            return board;
        }
            
        dfs(board, visited, i, j);
        
        return board;
    }
    
    private void dfs(char[][] board, boolean[][] visited, int i, int j) {
        if(i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || visited[i][j]) {
            return;
        }
        
        visited[i][j] = true;
        
        int mineNum = mines(board, i, j);
        if(mineNum != 0) {
            board[i][j] = (char)('0' + mineNum);
            return;
        }
        
        board[i][j] = 'B';
        
        for(int m = 0; m < 8 ; m ++) {
            int x = i + dx[m];
            int y = j + dy[m];
            dfs(board, visited, x, y);
        }
        
        return;
    }
    
    private int mines(char[][] board, int i, int j) {
        int mines = 0;
        for(int m = 0; m < 8 ; m ++) {
            int x = i + dx[m];
            int y = j + dy[m];
            if(x < 0 || x > board.length - 1 || y < 0 || y > board[0].length - 1) {
                continue; 
            }
            if(board[x][y] == 'M') {
                mines ++;
            }
        }
        
        return mines;
    }
}