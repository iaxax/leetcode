class Solution {
public:
	int longestValidParentheses(string s) {
		int maxL = 0, len = s.size();
		stack<int> stk;
		stk.push(-1);
		for (int i = 0; i < len; ++i) {
		    int t = stk.top();
		    if (t != -1 && s[i] == ')' && s[t] == '(') {
		        stk.pop();
		        maxL = std::max(maxL, i - stk.top());
		    }
		    else {
		        stk.push(i);
		    }
		}
		
		return maxL;
	}
};