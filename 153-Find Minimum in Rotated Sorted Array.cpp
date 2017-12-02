class Solution {
public:
    int findMin(vector<int>& nums) {
        return nums.size() == 0 ? 0 : findMin(nums, 0, nums.size() - 1);
    }
    
private:
    int findMin(const vector<int> &nums, int begin, int end) {
        if (begin > end) {
            return INT_MAX;
        }
        
        if (nums[begin] <= nums[end]) {
            return nums[begin];
        }
        
        int mid = (begin + end) / 2;
        return min(findMin(nums, begin, mid), findMin(nums, mid + 1, end));
    }
};

// iterative solution
class Solution {
public:
    int findMin(vector<int>& nums) {
        int begin = 0, end = nums.size() - 1;
        
        while (begin <= end) {
            if (nums[begin] <= nums[end]) {
                return nums[begin];
            }
            
            int mid = (begin + end) / 2;
            if (nums[mid] <= nums[end]) {
                end = mid;
            }
            else {
                begin = mid + 1;
            }
        }
        
        // normally unreachable
        return 0;
    }
};