class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int sz = prices.size();
        if (sz <= 1) return 0;
        
        vector<int> left(sz, 0);
        int leftMin = prices[0];
        for (int i = 1; i < sz; ++i) {
            left[i] = max(left[i - 1], prices[i] - leftMin);
            leftMin = min(leftMin, prices[i]);
        }
        
        vector<int> right(sz, 0);
        int rightMax = prices[sz - 1];
        for (int i = sz - 2; i >= 0; --i) {
            right[i] = max(right[i + 1], rightMax - prices[i]);
            rightMax = max(rightMax, prices[i]);
        }
        
        int profit = 0;
        for (int i = 1; i < sz - 1; ++i) {
            profit = max(profit, left[i] + right[i + 1]);
        }
        
        return max(profit, left[sz - 1]);
    }
};

// marvelous solution
class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int hold1 = numeric_limits<int>::min();
        int hold2 = numeric_limits<int>::min();
        int release1 = 0, release2 = 0;
        for (int p : prices) {
            release2 = max(release2, hold2 + p);
            hold2    = max(hold2, release1 - p);
            release1 = max(release1, hold1 + p);
            hold1    = max(hold1, -p);
        }
        return release2;
    }
};

class Solution {
public:
    int maxProfit(vector<int>& prices) {
        int lowestPrice1 = numeric_limits<int>::max();
        int lowestPrice2 = numeric_limits<int>::max();
        int maxProfit1 = 0, maxProfit2 = 0;
        for (int p : prices) {
            maxProfit2   = max(maxProfit2, p - lowestPrice2);
            lowestPrice2 = min(lowestPrice2, p - maxProfit1);
            maxProfit1   = max(maxProfit1, p - lowestPrice1);
            lowestPrice1 = min(lowestPrice1, p);
        }
        return maxProfit2;
    }
};
