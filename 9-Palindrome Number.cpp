class Solution {
public:
    bool isPalindrome(int x) {
        if (x < 0) return false;
        int len = 0, xx = x;
        while (xx > 0) {
            xx /= 10;
            len += 1;
        }
        
        int e = len - 1;
        while (x > 0) {
            int exp = (int)pow(10, e);
            if (x % 10 != x / exp) return false;
            x %= exp;
            x /= 10;
            e -= 2;
        }
        return true;
    }
};