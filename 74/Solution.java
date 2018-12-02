class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        if(matrix[0].length == 0) {
            return false;
        }
        int n = matrix[0].length - 1;
        
        int start = 0;
        int end = matrix.length - 1;
        
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(matrix[mid][0] > target) {
                end = mid;
            } else if(matrix[mid][n] < target) {
                start = mid;
            } else if(matrix[mid][0] == target || matrix[mid][n] == target) {
                return true;
            } else {
                return bs(matrix, mid, n, target);
            }
        }
        
        if(bs(matrix, start, n, target)) {
            return true;
        }
        
        if(bs(matrix, end, n, target)) {
            return true;
        }
        
        return false;
    }
    
    private boolean bs(int[][] matrix, int row, int n, int target) {
        int start = 0;
        int end = n;
        while(start + 1 < end) {
            int mid = start + (end - start) / 2;
            if(matrix[row][mid] == target) {
                return true;
            } else if(matrix[row][mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if(matrix[row][start] == target) {
            return true;
        }
        
        if(matrix[row][end] == target) {
            return true;
        }
        
        return false;
    }
}