class Solution {
public:
    string multiply(string num1, string num2) {
        int len1 = num1.size();
        int len2 = num2.size();
        int *pos = new int[len1 + len2];
        for (int i = len1 + len2 - 1; i >= 0; --i) {
            pos[i] = 0;
        }
        
        for (int i = len1 - 1; i >= 0; --i) {
            for (int j = len2 - 1; j >= 0; --j) {
                int mul = (num1[i] - '0') * (num2[j] - '0') + pos[i + j + 1];
                pos[i + j + 1] = mul % 10;
                pos[i + j] += mul / 10;
            }
        }
        
        int i = 0;
        while (i < len1 + len2 && pos[i] == 0) {
            ++i;
        }
        
        string result;
        while (i < len1 + len2) {
            result += char(pos[i++] + '0');
        }
        return result.length() == 0 ? "0" : result;
    }
};