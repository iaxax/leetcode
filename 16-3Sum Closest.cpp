class Solution {
public:
    int threeSumClosest(vector<int>& nums, int target) {
        int sz = nums.size();
        int minDiff = numeric_limits<int>::max();
        int result = 0;
        std::sort(nums.begin(), nums.end());
        
        for (int i = 0; i < sz - 2; ++i) {
            int front = i + 1, back = sz - 1;
            while (front < back) {
                int sum = nums[i] + nums[front] + nums[back];
                if (sum < target) {
                    if (target - sum < minDiff) {
                        minDiff = target - sum;
                        result = sum;
                    }
                    ++front;
                }
                else if (sum > target) {
                    if (sum - target < minDiff) {
                        minDiff = sum - target;
                        result = sum;
                    }
                    --back;
                }
                else {
                    return target;
                }
            }
            
            while (i + 1 < sz - 2 && nums[i + 1] == nums[i]) ++i;
        }
        return result;
    }
};