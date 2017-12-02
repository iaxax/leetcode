class Solution {
public:
    vector<string> letterCombinations(string digits) {
        if (digits.size() == 0) return {};
        
        vector<vector<char>> t = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
        };
        
        queue<string>q;
        q.push("");
        int len = digits.size();
        for (int i = 0; i < len; ++i) {
            while (q.front().size() == i) {
                string s = q.front();
                q.pop();
                for (char c : t[digits[i] - '2']) {
                    q.push(s + c);
                }
            }
        }
        
        vector<string> result;
        while (!q.empty()) {
            result.push_back(q.front());
            q.pop();
        }
        return result;
    }
};