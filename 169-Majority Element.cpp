// Moore voting solution
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int major, count = 0;
        for (int n : nums) {
            if (count == 0) {
                major = n;
                count = 1;
            }
            else {
                count += (major == n) ? 1 : -1;
            }
        }
        return major;
    }
};

// Bit manipulation solution
class Solution {
public:
    int majorityElement(vector<int>& nums) {
        int major = 0, mask = 1;
        for (int i = 0; i < 32; ++i, mask <<= 1) {
            int bitCount = 0;
            for (int n : nums) {
                if (n & mask) {
                    bitCount += 1;
                }
                if (bitCount > nums.size() / 2) {
                    major |= mask;
                    break;
                }
            }
        }
        return major;
    }
};