class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        for (int i = 1; i < nums.size(); ++i) {
            if (nums[i] < nums[i - 1]) {
                return i - 1;
            }
        }
        return nums.size() - 1;
    }
};

// O(logN) time complexity solution
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        int begin = 0, end = nums.size() - 1;
        
        while (begin <= end) {
            if (begin == end) {
                return begin;
            }
            
            int mid = (begin + end) / 2;
            if (nums[mid] < nums[mid + 1]) {
                begin = mid + 1;
            }
            else {
                end = mid;
            }
        }
        
        return 0;
    }
};

// recursive O(logN) solution
class Solution {
public:
    int findPeakElement(vector<int>& nums) {
        return findPeakElement(nums, 0, nums.size() - 1);   
    }
    
    
private:
    int findPeakElement(const vector<int> &nums, int begin, int end) {
        if (begin == end) {
            return begin;
        }
        
        int mid = (begin + end) / 2;
        return nums[mid] < nums[mid + 1] ?
			findPeakElement(nums, mid + 1, end) :
			findPeakElement(nums, begin, mid);
    }
};