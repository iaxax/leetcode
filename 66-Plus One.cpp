class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int size = digits.size();
        vector<int> result;
        result.resize(size);
        
        int carry = 1;
        for (int i = size - 1; i >= 0; --i) {
            int sum = digits[i] + carry;
            result[i] = sum % 10;
            carry = sum / 10;
        }
        
        if (carry > 0) {
            result.insert(result.begin(), carry);
        }
        return result;
    }
};