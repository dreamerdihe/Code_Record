class Solution {
    public int[][] updateMatrix(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix[0].length; j ++) {
                if(matrix[i][j] == 0) {
                    continue;
                }
                
                result[i][j] = distTo0(matrix, i, j);
            }
        }
        
        return result;
    }
    
    private int distTo0(int[][] matrix, int i, int j) {
        int dist = -1;
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{i, j});
        while(!queue.isEmpty()) {
            dist ++;
            int size = queue.size();
            for(int m = 0; m < size; m++) {
                int[] now = queue.poll();
                if(matrix[now[0]][now[1]] == 0) {
                    return dist;
                }
                for(int k = 0; k < 4; k++) {
                    int x = now[0] + dx[k];
                    int y = now[1] + dy[k];
                    if(x < 0 || x > matrix.length - 1 || y < 0 || y > matrix[0].length - 1) {
                        continue;
                    }
                    
                    queue.offer(new int[]{x, y});
                }    
            }
            
        }
        
        return dist;
    }
}