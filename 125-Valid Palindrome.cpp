class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0, right = s.size() - 1;
        while (left <= right) {
            while (left <= right && !isalnum(s[left])) ++left;
            while (right >= left && !isalnum(s[right])) --right;
            if (left <= right && tolower(s[left++]) != tolower(s[right--])) return false;
        }
        return true;
    }
};