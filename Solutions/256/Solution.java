class Solution {
    public int minCost(int[][] costs) {
        int red = 0;
        int blue = 0;
        int green = 0;
        for(int[] cost : costs) {
            int redTemp = Math.min(blue, green) + cost[0];
            int blueTemp = Math.min(red, green) + cost[1];
            int greenTemp = Math.min(red, blue) + cost[2];
            
            red = redTemp;
            blue = blueTemp;
            green = greenTemp;
        }
        
        return Math.min(Math.min(red, blue), green);
    }
}