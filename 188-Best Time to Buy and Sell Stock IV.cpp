class Solution {
public:
    int maxProfit(int k, vector<int>& prices) {
        if (k <= 0) return 0;
        
        if (k > prices.size() / 2) {
            int profit = 0;
            for (int i = 1; i < prices.size(); ++i) {
                profit += max(prices[i] - prices[i - 1], 0);
            }
            return profit;
        }
        
        vector<int> maxProfit(k, 0);
        vector<int> minPrice(k, numeric_limits<int>::max());
        for (int p : prices) {
            for (int i = k - 1; i >= 1; --i) {
                maxProfit[i] = max(maxProfit[i], p - minPrice[i]);
                minPrice[i]  = min(minPrice[i], p - maxProfit[i - 1]);
            }
            maxProfit[0] = max(maxProfit[0], p - minPrice[0]);
            minPrice[0]  = min(minPrice[0], p);
        }
        return maxProfit[k - 1];
    }
};