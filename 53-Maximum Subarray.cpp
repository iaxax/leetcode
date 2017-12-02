class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        nums.insert(nums.begin(), 0);
        for (int i = 1; i < nums.size(); ++i) {
            nums[i] = nums[i] + nums[i - 1];
        }
        
        int minNum = 0, result = nums[1];
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] - minNum > result) {
                result = nums[i] - minNum;
            }
            if (minNum > nums[i]) {
                minNum = nums[i];
            }
        }
        return result;
    }
};ʱ