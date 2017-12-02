class Solution {
public:
    int firstMissingPositive(vector<int>& nums) {
        int sz = nums.size();
        for (int i = 0; i < sz; ++i) {
            while (nums[i] > 0 && nums[i] <= sz && nums[nums[i] - 1] != nums[i]) {
                swap(nums[i], nums[nums[i] - 1]);
            }
        }
        
        for (int i = 0; i < sz; ++i) {
            if (nums[i] != i + 1) return i + 1;
        }
        
        return sz + 1;
    }
};