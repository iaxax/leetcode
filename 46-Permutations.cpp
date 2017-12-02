class Solution {
public:
    vector<vector<int>> permute(vector<int>& nums) {
        vector<vector<int>> result;
        permute(nums, 0, result);
        return result;
    }
    
private:
    void permute(vector<int> &nums, int start, vector<vector<int>> &result) {
        if (start >= nums.size()) {
            result.push_back(nums);
            return;
        }
        
        int sz = nums.size();
        for (int i = start; i < sz; ++i) {
            swap(nums[i], nums[start]);
            permute(nums, start + 1, result);
            swap(nums[i], nums[start]);
        }
    }
};