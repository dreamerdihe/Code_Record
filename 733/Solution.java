class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        if(image == null || image.length == 0 || image[0].length == 0) {
            return image;
        }
        
        int value = image[sr][sc];
        if(newColor == value) {
            return image;
        }
        
        dfs(image, value, sr, sc, newColor);
        return image;
    }
    
    private void dfs(int[][] image, int value, int x, int y, int newColor) {
        if(x < 0 || x > image.length - 1 || y < 0 || y > image[0].length - 1 || image[x][y] != value) {
            return;
        }
        
        image[x][y] = newColor;
        
        dfs(image, value, x + 1, y, newColor);
        dfs(image, value, x - 1, y, newColor);
        dfs(image, value, x, y + 1, newColor);
        dfs(image, value, x, y - 1, newColor);
        
        return;
    }
}