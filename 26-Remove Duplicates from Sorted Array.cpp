class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int sz = nums.size();
        if (sz < 2) return sz;
        
        int len = 0;
        for (int i = 0; i < sz; ++i) {
            while (i + 1 < sz && nums[i] == nums[i + 1]) {
                nums[len] = nums[++i];
            }
            if (i + 1 < sz) {
                nums[++len] = nums[i + 1];
            }
        }
        return len + 1;
    }
};