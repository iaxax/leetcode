// O(n^2) Solution
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[] dp = new int[n];
        int profit = 0;
        for (int i = n - 1; i >= 0; --i) {
            int temp = 0;
            for (int j = i + 1; j < n; ++j) {
                int p = prices[j] - prices[i];
                if (j + 2 < n) {
                    p += dp[j + 2];
                }
                if (p > temp) {
                    temp = p;
                }
            }
            if (temp > profit) {
                profit = dp[i] = temp;
            }
            else {
                dp[i] = profit;
            }
        }
        return profit;
    }
}

// O(n) Solution
class Solution {
    public int maxProfit(int[] prices) {
        int buy = Integer.MIN_VALUE, preBuy, sell = 0, preSell = 0;
        for (int p : prices) {
            preBuy = buy;
            buy = Math.max(preBuy, preSell - p);
            preSell = sell;
            sell = Math.max(preSell, preBuy + p);
        }
        return sell;
    }
}
