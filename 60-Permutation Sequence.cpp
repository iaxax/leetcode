class Solution {
public:
	string getPermutation(int n, int k) {
		list<char> l;
		for (int i = 0; i < n; ++i) {
			l.push_back(i + 1 + '0');
		}

		vector<int> fac = { 1 };
		for (int i = 1; i <= n; ++i) {
			fac.push_back(fac[i - 1] * (i));
		}

		--k;

		string result = "";
		for (int i = 1; i <= n; ++i) {
			int index = k / fac[n - i];
			auto it = l.begin();
			advance(it, index);
			result += *it;
			l.erase(it);
			k -= index * fac[n - i];
		}

		return result;
	}
};