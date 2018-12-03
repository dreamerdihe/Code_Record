class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        int low = matrix[0][0];
        int n = matrix.length;
        int high = matrix[n - 1][n - 1];
        
        while(low < high) {
            int mid = low + (high - low) / 2;
            
            int count = 0;
            for(int i = 0; i < matrix.length; i ++) {
                if(matrix[i][0] > mid) {
                    break;
                }
                
                if(matrix[i][n - 1] <= mid) {
                    count += n;
                    continue;
                }
                       
                for(int j = 0; j < matrix[0].length; j ++) {
                   if(matrix[i][j] <= mid) {
                        count ++;
                    }
                }    
            }
            
            if(count < k) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        
        return low;
    }
}