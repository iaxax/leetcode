class Solution {
public:
    vector<string> restoreIpAddresses(string s) {
        vector<string> result;
        restoreIpAddresses(result, "", s, 0, 0);
        return result;
    }

private:
    void restoreIpAddresses(vector<string> &result, string ip, const string &str, int start, int count) {
        if (count > 4) return;
        
        if (count == 4 && start == str.size()) {
            result.push_back(ip);
            return;
        }
        
        for (int i = 1; i < 4; ++i) {
            if (str.size() - start >= i) {
                string part = str.substr(start, i);
                if (part.size() == 1 || part[0] != '0' && strVal(part) <= 255) {
                    restoreIpAddresses(result, ip + part + (count == 3 ? "" : "."), str, start + i, count + 1);
                }
            }
        }
    }
    
    int strVal(const string &str) {
        int val = 0;
        for (int i = 0; i < str.size(); ++i) {
            val = val * 10 + str[i] - '0';
        }
        return val;
    }
};