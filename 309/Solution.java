class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if(n < 2) {
            return 0;
        }
        
        int[] buy = new int[n + 1];
        int[] sell = new int[n + 1];
        
        buy[1] = -prices[0];
        sell[1] = 0;
        for(int i = 2; i < n + 1; i ++) {
            int price = prices[i - 1];
            buy[i] = Math.max(sell[i - 2] - price, buy[i - 1]);
            sell[i] = Math.max(sell[i - 1], buy[i - 1] + price);
        }
        
        return Math.max(buy[n], sell[n]);
    }
}