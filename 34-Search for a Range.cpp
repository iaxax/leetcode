class Solution {
public:
    vector<int> searchRange(vector<int>& nums, int target) {
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
                int from = mid;
                while (from - 1 >= 0 && nums[from - 1] == target) --from;
                int to = mid;
                while (to + 1 < sz && nums[to + 1] == target) ++to;
                return {from, to};
            }
        }
        return {-1, -1};
    }
};