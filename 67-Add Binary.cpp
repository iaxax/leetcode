class Solution {
public:
    string addBinary(string a, string b) {
        int i = a.length() - 1, j = b.length() - 1;
        string result = "";
        
        int carry = 0;
        while (i >= 0 || j >= 0 || carry == 1) {
            int bit1 = i >= 0 ? a[i] - '0' : 0;
            int bit2 = j >= 0 ? b[j] - '0' : 0;
            int sum = bit1 + bit2 + carry;
            result = char('0' + sum % 2) + result;
            carry = sum / 2;
            --i; --j;
        }
        return result;
    }
};