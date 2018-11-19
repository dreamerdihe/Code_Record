class SolutionBfs {
    public int numIslands(char[][] grid) {
        if(grid.length == 0){
            return 0;
        }
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    getIslands(i, j, grid);
                    count ++;
                }
            } 
        }
        return count;
    }
    
    private void getIslands(int x0, int y0, char[][] grid) {
        int[] dy = {0, 0, -1, 1};
        int[] dx = {-1, 1, 0, 0};
        
        Queue<List<Integer>> queue = new LinkedList();
        List<Integer> coor = new ArrayList();
        coor.add(x0);
        coor.add(y0);
        queue.offer(coor);
        
        while(!queue.isEmpty()) {
            List<Integer> current = queue.poll();
            int x = current.get(0);
            int y = current.get(1);
            grid[x][y] = '0';
            
            for(int m = 0; m < 4; m++){
                int x_ = x + dx[m];
                int y_ = y + dy[m];
                
                if(x_ >= 0 && y_ >= 0 && x_ < grid.length && y_ < grid[0].length) {
                    if(grid[x_][y_] == '1'){
                        List<Integer> coor_ = new ArrayList();
                        coor_.add(x_);
                        coor_.add(y_);
                        queue.offer(coor_);
                        grid[x_][y_] = '0';
                    }
                }
            }
        }
    }
}









