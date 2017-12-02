class Solution {
public:
    int maxProduct(vector<int>& nums) {
        if (nums.size() == 0) {
            return 0;
        }
        
        int maxHere = nums[0], minHere = nums[0], maxSofar = nums[0];
        for (int i = 1; i < nums.size(); ++i) {
            int mh = maxHere;
            maxHere = max(max(maxHere * nums[i], minHere * nums[i]), nums[i]);
            minHere = min(min(mh * nums[i], minHere * nums[i]), nums[i]);
            maxSofar = max(maxSofar, maxHere);
        }
        
        return maxSofar;
    }
};