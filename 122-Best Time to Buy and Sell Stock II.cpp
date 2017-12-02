class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int sz = prices.size();
        int profit = 0, left = 0, right = 0;
        while (right < sz) {
            while (right + 1 < sz && prices[right + 1] >= prices[right]) {
                right = right + 1;
            }
            profit += prices[right] - prices[left];
            left = right = right + 1;
        }
        return profit;
    }
};