class Solution {
public:
	vector<string> generateParenthesis(int n) {
		queue<pair<string, int>> *q = new queue<pair<string, int>>;
		q->push({ "", 0 });
		for (int i = 0; i < 2 * n; ++i) {
			while (q->front().first.size() == i) {
				const pair<string, int>& t = q->front();
				if (t.second <= n && i == 2 * t.second) {
					q->push({ t.first + '(', t.second + 1 });
				}
				else if (t.second == n) {
					q->push({ t.first + ')', t.second });
				}
				else {
					q->push({ t.first + '(', t.second + 1 });
					q->push({ t.first + ')', t.second });
				}
				q->pop();
			}
		}

		vector<string> result;
		while (!q->empty()) {
			result.push_back(q->front().first);
			q->pop();
		}
		delete q;
		return result;
	}
};
