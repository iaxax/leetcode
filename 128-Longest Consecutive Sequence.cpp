class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, int> mp;
        for (int n : nums) mp[n] = 1;
        
        int result = 0;
        while (mp.size() > 0) {
            int n = mp.begin()->first;
            int temp = n - mp[n];
            while (mp.find(temp) != mp.end()) {
                mp[n] += mp[temp];
                mp.erase(temp);
                temp = n - mp[n];
            }
            
            temp = n + 1;
            while (mp.find(temp) != mp.end()) {
                mp[temp] = mp[temp - 1] + 1;
                mp.erase(temp - 1);
                temp = temp + 1;
            }
            
            result = max(result, mp[temp - 1]);
            mp.erase(temp - 1);
        }
        return result;
    }
};

// shorter solution
class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        unordered_map<int, int> mp;
        int result = 0;
        for (int n : nums) {
            if (mp[n]) continue;
            result = max(result, mp[n] = mp[n - mp[n - 1]] = mp[n + mp[n + 1]] = mp[n - 1] + mp[n + 1] + 1);
        }
        return result;
    }
};