// bfs: O(kn) where k is the number of 0
class SolutionBfs {
    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        if(rows == 0) {
            return;
        }
        int cols = rooms[0].length;
        
        for(int x = 0; x < rows; x++) {
            for(int y = 0; y < cols; y++) {
                if(rooms[x][y] == 0) {
                    update(x, y, rooms);
                } 
            }
        }
    }
    
    private void update(int x, int y, int[][] rooms) {
        int rows = rooms.length;
        int cols = rooms[0].length;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        Queue<List<Integer>> queue = new LinkedList<>();
        List<Integer> coor = new ArrayList<>();
        coor.add(x);
        coor.add(y);
        queue.offer(coor);
        
        int level = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            level ++;
            for(int i = 0; i < size; i++) {
                List<Integer> now = queue.poll();
                for(int j = 0; j < 4; j++) {
                    int xx = now.get(0) + dx[j];
                    int yy = now.get(1) + dy[j];
                    if(xx > -1 && xx < rows && yy > -1 && yy < cols && rooms[xx][yy] != -1 && rooms[xx][yy] != 0 && level < rooms[xx][yy]) {
                        List<Integer> coor_ = new ArrayList<>();
                        rooms[xx][yy] = level;
                        coor_.add(xx);
                        coor_.add(yy);
                        queue.offer(coor_);
                    }
                }
                
            }
        }   
    }
}