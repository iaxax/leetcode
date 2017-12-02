class Solution {
public:
    int search(vector<int>& nums, int target) {
        int bound = 0, sz = nums.size();
        if (sz == 0) return -1;
        
        while (bound + 1 < sz && nums[bound] < nums[bound + 1]) {
            ++bound;
        }
        
        if (target > nums[0]) {
            return bsearch(nums, target, 0, bound);
        }
        else if (target < nums[0]) {
            return bsearch(nums, target, bound + 1, sz - 1);
        }
        else {
            return 0;
        }
    }
private:
    int bsearch(const vector<int>& nums, int target, int begin, int end) {
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (target == nums[mid]) {
                return mid;
            }
            else if (target > nums[mid]) {
                begin = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        
        return -1;
    }
};