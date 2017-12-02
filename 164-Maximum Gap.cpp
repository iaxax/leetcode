class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int size = nums.size();
        if (size < 2) {
            return 0;
        }
        
        int minNum = numeric_limits<int>::max();
        int maxNum = numeric_limits<int>::min();
        for (int n : nums) {
            minNum = min(minNum, n);
            maxNum = max(maxNum, n);
        }
        
        int minBuckets[size - 1];
        int maxBuckets[size - 1];
        for (int i = 0; i < size - 1; ++i) {
            minBuckets[i] = numeric_limits<int>::max();
            maxBuckets[i] = numeric_limits<int>::min();
        }
        
        int gap = ceil(double(maxNum - minNum) / (size - 1));
        for (int n : nums) {
            if (n != minNum && n != maxNum) {
                int i = (n - minNum) / gap;
                minBuckets[i] = min(minBuckets[i], n);
                maxBuckets[i] = max(maxBuckets[i], n);
            }
        }
        
        int maxGap = INT_MIN;
        int previous = minNum;
        for (int i = 0; i < size - 1; ++i) {
            if (minBuckets[i] != INT_MAX && maxBuckets[i] != INT_MIN) {
                maxGap = max(maxGap, minBuckets[i] - previous);
                previous = maxBuckets[i];
            }
        }
        
        maxGap = max(maxGap, maxNum - previous);
        return maxGap;
    }
};