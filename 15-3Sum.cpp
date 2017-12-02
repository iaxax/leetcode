class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        int sz = nums.size();
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        for (int i = 0; i < sz - 2; ++i) {
            int m = i + 1, n = sz - 1;
            while (m < n) {
                if (nums[m] + nums[i] + nums[n] > 0) {
                    --n;
                }
                else if (nums[m] + nums[i] + nums[n] < 0) {
                    ++m;
                }
                else {
                    result.push_back({nums[m], nums[i], nums[n]});
                    int a = nums[m], b = nums[n];
                    while (m < n && nums[m] == a) ++m;
                    while (m < n && nums[n] == b) --n;
                }
            }
            
            while (i + 1 < sz - 2 && nums[i + 1] == nums[i]) ++i;
        }
        
        return result;
    }
};