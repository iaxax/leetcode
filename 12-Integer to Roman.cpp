class Solution {
public:
    string intToRoman(int num) {
        const char ch[] = {'I', 'V', 'X', 'L', 'C', 'D', 'M'};
        int len = length(num);
        
        string result = "";
        int bit;
        while (len > 0) {
            bit = num / (int)pow(10, len - 1);
            if (bit == 9) {
                result += ch[len * 2 - 2];
                result += ch[len * 2];
            }
            else if (bit >= 5) {
                result += ch[len * 2 - 1];
                for (int i = bit; i > 5; --i) {
                    result += ch[len * 2 - 2];
                }
            }
            else if (bit == 4) {
                result += ch[len * 2 - 2];
                result += ch[len * 2 - 1];
            }
            else {
                for (int i = bit; i >= 1; --i) {
                    result += ch[len * 2 - 2];
                }
            }
            num %= (int)pow(10, len - 1);
            len = length(num);
        }
        return result;
    }
    
private:
    inline int length(int num) {
        int len = 0;
        while (num > 0) {
            num /= 10;
            ++len;
        }
        return len;
    }
};