class Solution {
    // O(m + n)
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length < 1) {
            return false;
        }
        
        int m = matrix.length - 1;
        int n = matrix[0].length - 1;
        
        int x = 0;
        int y = n;
        
        while(x <= m && y >= 0) {
            int cur = matrix[x][y];
            if(cur == target) {
                return true;
            } else if(cur < target) {
                x ++;
            } else {
                y --;
            }
        }
        
        return false;
    }
}