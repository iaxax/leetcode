class Solution {
public:
    int romanToInt(string s) {
        unordered_map<char, int> mp;
        mp.insert({'I', 1});
        mp.insert({'V', 5});
        mp.insert({'X', 10});
        mp.insert({'L', 50});
        mp.insert({'C', 100});
        mp.insert({'D', 500});
        mp.insert({'M', 1000});
        
        int len = s.size(), i = 0;
        int value = 0;
        while (i < len) {
            if (i + 1 < len && mp[s[i]] < mp[s[i + 1]]) {
                value += mp[s[i + 1]] - mp[s[i]];
                i += 2;
            }
            else {
                value += mp[s[i]];
                i += 1;
            }
        }
        return value;
    }
};