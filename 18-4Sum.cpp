class Solution {
public:
    vector<vector<int>> fourSum(vector<int>& nums, int target) {
        vector<vector<int>> result;
        std::sort(nums.begin(), nums.end());
        
        int sz = nums.size();
        for (int i = 0; i < sz; ++i) {
            for (int j = i + 1; j < sz; ++j) {
                int front = j + 1, back = sz - 1;
                while (front < back) {
                    int sum = nums[i] + nums[j] + nums[front] + nums[back];
                    if (sum > target) {
                        --back;
                    }
                    else if (sum < target) {
                        ++front;
                    }
                    else {
                        result.push_back({nums[i], nums[j], nums[front], nums[back]});
                        int a = nums[front], b = nums[back];
                        while (front < back && nums[front] == a) ++front;
                        while (front < back && nums[back] == b) --back;
                    }
                }
                
                while (j + 1 < sz && nums[j] == nums[j + 1]) ++j;
            }
            while (i + 1 < sz && nums[i] == nums[i + 1]) ++i;
        }
        
        return result;
    }
};