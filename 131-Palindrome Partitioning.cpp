class Solution {
public:
    vector<vector<string>> partition(string s) {
        vector<vector<string>> result;
        vector<string> temp;
        partition(result, temp, s, 0);
        return result;
    }
    
private:
    void partition(vector<vector<string>> &result, vector<string> &temp, const string &s, int start) {
        if (start == s.size()) {
            result.push_back(temp);
            return;
        }
        
        for (int i = start; i < s.size(); ++i) {
            int left = start, right = i;
            while (left < right && s[left] == s[right]) {
                ++left; --right;
            }
            
            if (left >= right) {
                temp.push_back(s.substr(start, i - start + 1));
                partition(result, temp, s, i + 1);
                temp.pop_back();
            }
        }
    }
};