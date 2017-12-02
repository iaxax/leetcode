class Solution {
public:
    bool search(vector<int>& nums, int target) {
        int begin = 0, end = nums.size() - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (nums[mid] == target) return true;
            
            if (nums[begin] == nums[mid] && nums[mid] == nums[end]) {
                ++begin; -- end;
            }
            else if (nums[begin] <= nums[mid]) {
                if (nums[begin] <= target && target < nums[mid]) end = mid - 1;
                else begin = mid + 1;
            }
            else {
                if (nums[mid] < target && target <= nums[end]) begin = mid + 1;
                else end = mid - 1;
            }
        }
        
        return false;
    }
};