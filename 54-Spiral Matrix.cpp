class Solution {
public:
	vector<int> spiralOrder(vector<vector<int>>& matrix) {
	    vector<int> result;
	    
	    int row = matrix.size();
	    if (row == 0) return result;
	    
	    int col = matrix[0].size();
	    if (col == 0) return result;
	    
	    vector<vector<int>> dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
	    int dirIdx = 0;
	    int length[2] = {col, row - 1};
	    int r = 0, c = -1;
	    while (length[dirIdx % 2]) {
	        for (int i = 0; i < length[dirIdx % 2]; ++i) {
	            r += dir[dirIdx][0];
	            c += dir[dirIdx][1];
	            result.push_back(matrix[r][c]);
	        }
	        length[dirIdx % 2]--;
	        dirIdx = (dirIdx + 1) % 4;
	    }
	    
		return result;
	}
};