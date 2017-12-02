class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int sz = prices.size();
        if (sz <= 1) return 0;
        
        int profit = 0, minPrice = prices[0];
        for (int i = 1; i < sz; ++i) {
            if (prices[i] - minPrice > profit)
                profit = prices[i] - minPrice;
                
            if (prices[i] < minPrice)
                minPrice = prices[i];
        }
        
        return profit;
    }
};