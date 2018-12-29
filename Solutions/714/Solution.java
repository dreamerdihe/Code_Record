class Solution {
    public int maxProfit(int[] prices, int fee) {
        if(prices.length < 2) {
            return 0;
        }
        
        int buy = -prices[0];
        int sell = 0;
        for(int i = 1; i < prices.length; i ++) {
            int temp = buy;
            buy = Math.max(temp, sell - prices[i]);
            sell = Math.max(sell, temp + prices[i] - fee);
        }
        
        return sell < 0 ? 0 : sell;
    }
}