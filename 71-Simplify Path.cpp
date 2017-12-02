class Solution {
public:
    string simplifyPath(string path) {
        stack<string> stk;
        stringstream ss(path);
        string step;
        while (getline(ss, step, '/')) {
            if (step == "" || step == ".") continue;
            if (step == ".." && !stk.empty()) {
                stk.pop();
            }
            else if (step != "..") {
                stk.push(step);
            }
        }
        
        string result("");
        while (!stk.empty()) {
            result = string("/") + stk.top() + result;
            stk.pop();
        }
        return result.empty() ? "/" : result;
    }
};