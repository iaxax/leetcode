class Solution {
public:
    int totalNQueens(int n) {
        vector<int> queens;
        int result = 0;
        totalNQueens(queens, n, 0, result);
        return result;
    }

private:
    void totalNQueens(vector<int> &queens, int n, int row, int &result) {
        if (row == n) {
            result += 1;
            return;
        }
        
        for (int i = 0; i < n; ++i) {
            if (queenValid(queens, row, i)) {
                queens.push_back(i);
                totalNQueens(queens, n, row + 1, result);
                queens.pop_back();
            }
        }
    }
    
    bool queenValid(const vector<int> &queens, int row, int col) {
        for (int i = 0; i < queens.size(); ++i) {
            if (col == queens[i] || (abs(i - row) == abs(queens[i] - col))) {
                return false;
            }
        }
        return true;
    }
};