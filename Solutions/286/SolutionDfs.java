// consider the solution of dfs:

class SolutionDfs {
    public void wallsAndGates(int[][] rooms) {
        for(int x = 0; x < rooms.length; x++) {
            for(int y = 0; y < rooms[x].length; y ++) {
                if(rooms[x][y] == 0) {
                    dfs(x, y, rooms, 0);
                }
            }
        }
    }
    
    //set the room[x][y] as d
    private void dfs(int x, int y, int[][] rooms, int d) {
        if(x < 0 || y <0 || x > rooms.length - 1 || y > rooms[x].length - 1 || rooms[x][y] == -1 || d > rooms[x][y]) {
            return;
        }
        
        rooms[x][y] = d;
        
        dfs(x - 1, y, rooms, d +1);
        dfs(x + 1, y, rooms, d +1);
        dfs(x, y - 1, rooms, d +1);
        dfs(x, y + 1, rooms, d +1);
    }
}