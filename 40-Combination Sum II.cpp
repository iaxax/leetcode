class Solution {
public:
	vector<vector<int>> combinationSum2(vector<int>& candidates, int target) {
	    sort(candidates.begin(), candidates.end());
		vector<vector<int>> result;
		vector<int> temp;
		backtrace(result, temp, candidates, target, 0);
		return result;
	}
private:
    void backtrace(vector<vector<int>> &result, vector<int> &temp, const vector<int> &candidates, int remain, int start) {
        if (remain < 0) return;
        else if (remain == 0) {
            result.push_back(temp);
        }
        else {
            for (int i = start; i < candidates.size(); ++i) {
                if (i > start && candidates[i] == candidates[i - 1]) continue;
                temp.push_back(candidates[i]);
                backtrace(result, temp, candidates, remain - candidates[i], i + 1);
                temp.pop_back();
            }
        }
    }

};