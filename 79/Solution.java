class Solution {
    public boolean exist(char[][] board, String word) {
        if(board.length == 0 && word.length() == 0) {
            return true;
        }
        
        for(int x = 0; x < board.length; x ++) {
            for(int y = 0; y < board[x].length; y ++) {
                if(helper(x, y, board, word, 0)) {
                    return true;
                }         
            }
        }
        return false;
    }
    
    private boolean helper(int x, int y, char[][] board, String word, int index) {
        if(index == word.length()) {
            return true;
        }
        
        if(x < 0 || x > board.length - 1 || y < 0 || y > board[x].length -1 || board[x][y] != word.charAt(index)) {
            return false;
        }
        
        char temp = board[x][y];
        board[x][y] = '0';
        
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        for(int i = 0; i < 4; i ++) {
            
            if(helper(x + dx[i], y + dy[i], board, word, index + 1)) {
                return true;
            }
        }
        
        board[x][y] = temp;
        return false;
    }
}