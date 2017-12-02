class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        int len = s.size();
        int i = 0, result = 0, num = 0;
        set<char> st;
        while (i < len) {
            if (st.find(s[i]) == st.end()) {
                st.insert(s[i]);
                ++num; ++i;
            }
            else {
                result = max(result, num);
                num = 0;
                i = i - st.size() + 1;
                st.clear();
            }
        }
        return max(result, num);
    }
};