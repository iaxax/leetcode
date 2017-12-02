class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        int sz = nums.size();
        if (sz == 0) return;
        
        int rightMaxPos = sz - 1;
        while (rightMaxPos - 1 >= 0 && nums[rightMaxPos - 1] >= nums[rightMaxPos]) {
            --rightMaxPos;
        }
        
        if (rightMaxPos == 0) {
            reverse(nums, 0, sz - 1);
        }
        else {
            int& n = nums[rightMaxPos - 1];
            int pos = sz - 1;
            while (n >= nums[pos]) --pos;
            std::swap(n, nums[pos]);
            reverse(nums, rightMaxPos, sz - 1);
        }
    }
private:
    void reverse(vector<int> &nums, int begin, int end) {
        int mid = (begin + end) / 2;
        for (int i = begin; i <= mid; ++i) {
            std::swap(nums[i], nums[end - (i - begin)]);
        }
    }
};