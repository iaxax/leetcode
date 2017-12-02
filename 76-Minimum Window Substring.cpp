class Solution {
public:
    string minWindow(string s, string t) {
        vector<int> mp(128, 0);
        for (char c : t) mp[c] += 1;
        
        int count = t.size(), left = 0, right = 0;
        int begin = 0, len = numeric_limits<int>::max();
        while (right < s.size()) {
            if (mp[s[right++]]-- > 0) --count;
            while (count == 0) {
                if (len > right - left) len = right - (begin = left);
                if (mp[s[left++]]++ == 0) ++count;
            }
        }
        return len == numeric_limits<int>::max() ? "" : s.substr(begin, len);
    }
};