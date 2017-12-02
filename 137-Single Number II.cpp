class Solution {
public:
    int singleNumber(vector<int>& nums) {
        int bit0 = 0, bit1 = 0;
        for (int n : nums) {
            bit0 = (bit0 ^ n) & (~bit1);
            bit1 = (bit1 ^ n) & (~bit0);
        }
        return bit0;
    }
};