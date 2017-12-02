class Solution {
public:
    bool isNumber(string s) {
        int len = s.length();
        int start = 0, end = len - 1;
        while (start < len && isspace(s[start])) {
            ++start;
        }
        while (end >= 0 && isspace(s[end])) {
            --end;
        }
        
        bool numSeen = false, numAfterE = false;
        bool dotSeen = false, eSeen = false;
        for (int i = start; i <= end; ++i) {
            if (s[i] >= '0' && s[i] <= '9') {
                numSeen = numAfterE = true;
            }
            else if (s[i] == '.') {
                if (dotSeen || eSeen) {
                    return false;
                }
                dotSeen = true;
            }
            else if (s[i] == 'e') {
                if (eSeen || !numSeen) {
                    return false;
                }
                numAfterE = false;
                eSeen = true;
            }
            else if (s[i] == '+' || s[i] == '-') {
                if (i != start && s[i - 1] != 'e') {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        
        return numSeen && numAfterE;
    }
};