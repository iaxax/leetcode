class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        int sz = nums.size();
        int begin = 0, end = sz - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] > target) {
                end = mid - 1;
            }
            else if (nums[mid] < target) {
                begin = mid + 1;
            }
            else {
                return mid;
            }
        }
        
        return begin;
    }
};