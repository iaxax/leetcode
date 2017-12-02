class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> result;
        vector<multiset<char>> v;
        
        for (const string &str : strs) {
            multiset<char> ms;
            for (char c : str) ms.insert(c);
            
            int pos = 0;
            while (pos < v.size()) {
                if (v[pos] == ms) break;
                ++pos;
            }
            
            if (pos >= v.size()) {
                v.push_back(ms);
                result.push_back({str});
            }
            else {
                result[pos].push_back(str);
            }
        }
        
        return result;
    }
};