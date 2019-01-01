class Solution {
    private int result = 0;
    
    public int removeStones(int[][] stones) {        
        if(stones.length == 0) {
            return 0;
        }
        
        boolean[] visited = new boolean[stones.length];
        for(int i = 0; i < visited.length; i ++) {
            if(!visited[i]) {
                visited[i] = true;
                dfs(stones, visited, stones[i]);     
            }
        }
        
        return result;
    }
    
    private void dfs(int[][] stones, boolean[] visited, int[] now) {
        
        for(int i = 0; i < stones.length; i ++) {
            if((now[0] == stones[i][0] || now[1] == stones[i][1]) && !visited[i]) {
                result ++;
                visited[i] = true;
                dfs(stones, visited, stones[i]);
            }
        }
        
        return;
    }
}