class Solution {
public:
    vector<vector<int>> subsetsWithDup(vector<int>& nums) {
        vector<vector<int>> result;
        sort(nums.begin(), nums.end());
        subsetWithDup(result, nums, 0);
        return result;
    }
    
private:
    void subsetWithDup(vector<vector<int>> &result, vector<int> &nums, int start) {
        if (start == nums.size()) {
            result.push_back(nums);
            return;
        }
        
        int n = nums[start];
        int end = start + 1;
        while (end < nums.size() && nums[end] == n) ++end;
        
        nums.erase(nums.begin() + start, nums.begin() + end);
        subsetWithDup(result, nums, start);
        nums.insert(nums.begin() + start, end -start, n);
        
        subsetWithDup(result, nums, start + 1);
    }
};