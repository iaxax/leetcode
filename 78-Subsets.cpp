class Solution {
public:
    vector<vector<int>> subsets(vector<int>& nums) {
        vector<vector<int>> result;
        subsets(result, nums, 0);
        return result;
    }
    
private:
    void subsets(vector<vector<int>> &result, vector<int> &nums, int start) {
        if (start == nums.size()) {
            result.push_back(nums);
            return;
        }
        
        int n = nums[start];
        nums.erase(nums.begin() + start);
        subsets(result, nums, start);
        nums.insert(nums.begin() + start, n);
        subsets(result, nums, start + 1);
    }
};