class Solution {
    public int maxProfit(int[] prices, int fee) {
        int days = prices.length;
        int buy = -prices[0], sell = 0;
        for (int i = 1; i < days; ++i) {
            int b = buy;
            buy = Math.max(buy, sell - prices[i]);
            sell = Math.max(sell, b + prices[i] - fee);
        }
        return sell;
    }
}