class Solution {
public:
    vector<int> twoSum(vector<int>& numbers, int target) {
        int size = numbers.size();
        int left = 0, right = size - 1;
        while (right >= 0 && numbers[right] > target) {
            --right;
        }
        
        while (left < right) {
            if (numbers[left] + numbers[right] == target) {
                return {left + 1, right + 1};
            }
            
            if (numbers[left] + numbers[right] > target) {
                --right;
            }
            else {
                ++left;
            }
        }
        
        // impossibly reach here !!!
        return {1, 2};
    }
};