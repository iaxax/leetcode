class Solution {
public:
	vector<vector<int>> combinationSum(vector<int>& candidates, int target) {
		sort(candidates.begin(), candidates.end());
		int sz = candidates.size();
		if (sz == 0) return {};

		queue<pair<vector<int>, int>> q;
		int count = 0;
		for (int n : candidates) {
			if (n == target) ++count;
			q.push({ {n}, n });
		}

		while (true) {
		    const auto &p = q.front();
			for (int i = 0; i < sz; ++i) {
				if (p.first.back() > candidates[i]) continue;
				if (p.second + candidates[i] <= target) {
					if (p.second + candidates[i] == target) ++count;
					vector<int> v = p.first;
					v.push_back(candidates[i]);
					q.push({ v, p.second + candidates[i] });
				}
				else {
				    if (p.second == target) q.push(p);
					break;
				}
			}
			q.pop();

			if (count == q.size()) break;
		}

		vector<vector<int>> result;
		while (!q.empty()) {
			result.push_back(q.front().first);
			q.pop();
		}
		return result;
	}
};
