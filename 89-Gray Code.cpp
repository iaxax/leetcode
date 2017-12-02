class Solution {
public:
    vector<int> grayCode(int n) {
        vector<int> v(n + 1, 1);
        for (int i = 1; i <= n; ++i) {
            v[i] = v[i - 1] * 2;
        }
        
        vector<int> result = {0};
        result.reserve(v[n]);
        for (int i = 0; i < n; ++i) {
            int sz = result.size();
            for (int j = sz - 1; j >= 0; --j) {
                result.push_back(result[j] + v[i]);
            }
        }
        
        return result;
    }

};

// Excellent but not understandable solution
class Solution {
public:
    vector<int> grayCode(int n) {
        int sz = 1 << n;
        vector<int> result(sz);
        for (int i = 0; i < sz; ++i) {
            result[i] = (i ^ (i >> 1));
        }
        return result;
    }
};