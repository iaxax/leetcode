class Solution {
public:
	vector<int> findSubstring(string s, vector<string>& words) {
		int sz = words.size();
		if (sz == 0) return{};

		unordered_map<string, int> mp;
		for (const string &str : words) mp[str]++;
		int wordLen = words[0].size();
		int len = s.size();
		int end = len - wordLen * sz;
		vector<int> result;
		for (int i = 0; i <= end; ++i) {
		    unordered_map<string, int> tmp;
		    int j = 0;
		    for (; j < sz; ++j) {
		        const string &str = s.substr(i + j * wordLen, wordLen);
		        if (mp.find(str) != mp.end()) {
		            tmp[str]++;
		            if (tmp[str] > mp[str]) break;
		        }
		        else {
		            break;
		        }
		    }
		    
		    if (j == sz) result.push_back(i);
		}
		
		return result;
	}
};