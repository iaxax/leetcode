class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        if (strs.size() == 0) return "";
        
        int len = minLen(strs);
        vector<char> common;
        for (int i = 0; i < len; ++i) {
            vector<char> v;
            for (const string &s : strs) v.push_back(s[i]);
            if (isSame(v)) {
                common.push_back(v[0]);
            }
            else {
                break;
            }
        }
        
        string result = "";
        int sz = common.size();
        for (int i = 0; i < sz; ++i) result += common[i];
        return result;
    }
private:
    int minLen(const vector<string> &v) {
        int len = v[0].size();
        for (const string &s : v) {
            if (s.size() < len) len = s.size();
        }
        return len;
    }
    
    int isSame(const vector<char> &v) {
        char c = v[0];
        int sz = v.size();
        for (int i = 1; i < sz; ++i) {
            if (v[i] != c) return false;
        }
        return true;
    }
};