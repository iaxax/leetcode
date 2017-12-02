class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int row = matrix.size();
        if (row == 0) return false;
        int col = matrix[0].size();
        if (col == 0) return false;
        
        int begin = 0, end = row - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (matrix[mid][0] < target) {
                begin = mid + 1;
            }
            else if (matrix[mid][0] > target) {
                end = mid - 1;
            }
            else {
                return true;
            }
        }
        
        int r = begin == 0 ? 0 : begin - 1;
        begin = 0; end = col - 1;
        while (begin <= end) {
            int mid = (begin + end) / 2;
            if (matrix[r][mid] < target) {
                begin = mid + 1;
            }
            else if (matrix[r][mid] > target) {
                end = mid - 1;
            }
            else {
                return true;
            }
        }
        return false;
    }

};