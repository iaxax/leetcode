class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        map<int, int> mp;
        int size = nums.size();
        for(int i = 0; i < size; ++i) {
            if(mp.find(nums[i]) != mp.end()) {
                return {mp[nums[i]], i};
            }
            mp.insert({target - nums[i], i});
        }
        
        //impossible
        return {0, 1};
    }
};