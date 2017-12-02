class Solution {
public:
    vector<vector<int>> combine(int n, int k) {
        vector<int> nums;
        vector<vector<int>> result;
        combine(nums, 1, n, k, result);
        return result;
    }
    
private:
    void combine(vector<int> &nums, int start, int n, int remain, vector<vector<int>> &result) {
        if (remain == 0) {
            result.push_back(nums);
            return;
        }
        
        for (int i = start; i <= n; ++i) {
            nums.push_back(i);
            combine(nums, i + 1, n, remain - 1, result);
            nums.pop_back();
        }
    }
};