class Solution {
public:
    int candy(vector<int>& ratings) {
        if (ratings.size() <= 1) return ratings.size();
        
        int rateSize = ratings.size();
        vector<int> candies(rateSize, 1);
        
        for (int i = 1; i < rateSize; ++i) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }
        }
        
        for (int i = rateSize - 1; i >= 1; --i) {
            if (ratings[i - 1] > ratings[i]) {
                candies[i - 1] = max(candies[i - 1], candies[i] + 1);
            }
        }
        
        int num = 0;
        for (int cdy : candies) {
            num += cdy;
        }
        return num;
    }
};