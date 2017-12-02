class Solution {
public:
    bool isValid(string s) {
        int len = s.size();
        stack<char> sta;
        for (int i = 0; i < len; ++i) {
            if (s[i] == '(' || s[i] == '[' || s[i] == '{') {
                sta.push(s[i]);
            }
            else if (!sta.empty()) {
                char c = sta.top();
                if ((c == '(' && s[i] == ')') || (c == '[' && s[i] == ']')
                    || (c == '{' && s[i] == '}'))
                {
                    sta.pop();
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return sta.empty();
    }
};