class Solution {
public:
    vector<vector<int>> permuteUnique(vector<int>& nums) {
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
        
        set<int> used;
        for (int i = start; i < nums.size(); ++i) {
            if (used.find(nums[i]) != used.end()) continue;
            swap(nums[i], nums[start]);
            permute(nums, start + 1, result);
            swap(nums[i], nums[start]);
            used.insert(nums[i]);
        }
    }
};