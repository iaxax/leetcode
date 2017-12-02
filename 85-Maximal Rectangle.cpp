class Solution {
public:
	int maximalRectangle(vector<vector<char>>& matrix) {
		int row = matrix.size();
		if (row == 0) return 0;
		int col = matrix[0].size();
		if (col == 0) return 0;

		vector<int> heights(col, 0);
		int maxArea = 0;
		for (int i = 0; i < row; ++i) {
			for (int j = 0; j < col; ++j) {
				heights[j] = matrix[i][j] == '0' ? 0 : heights[j] + 1;
			}

			int area = 0;
			stack<int> index;
			heights.push_back(0);

			for (int j = 0; j <= col; ++j) {
				while (!index.empty() && heights[index.top()] >= heights[j]) {
					int h = heights[index.top()];
					index.pop();
					int left = index.empty() ? -1 : index.top();
					if (area < h * (j - 1 - left)) {
						area = h * (j - 1 - left);
					}
				}
				index.push(j);
			}

			heights.pop_back();
			if (area > maxArea) {
				maxArea = area;
			}
		}
		return maxArea;
	}
};

// DP Solution
class Solution {
public:
    int maximalRectangle(vector<vector<char>>& matrix) {
        int row = matrix.size();
        if (row == 0) return 0;
        int col = matrix[0].size();
        if (col == 0) return 0;
        
        vector<int> left(col, 0);
        vector<int> right(col, col);
        vector<int> height(col, 0);
        int maxArea = 0;
        for (int i = 0; i < row; ++i) {
            int cur_left = 0, cur_right = col;
            
            for (int j = 0; j < col; ++j) {
                height[j] = matrix[i][j] == '0' ? 0 : height[j] + 1;
            }
            
            for (int j = 0; j < col; ++j) {
                if (matrix[i][j] == '1') {
                    left[j] = max(left[j], cur_left);
                }
                else {
                    cur_left = j + 1; left[j] = 0;
                }
            }
            
            for (int j = col - 1; j >= 0; --j) {
                if (matrix[i][j] == '1') {
                    right[j] = min(right[j], cur_right);
                }
                else {
                    cur_right = j; right[j] = col;
                }
            }
            
            for (int j = 0; j < col; ++j) {
                if ((right[j] - left[j]) * height[j] > maxArea) {
                    maxArea = (right[j] - left[j]) * height[j];
                }
            }
        }
        return maxArea;
    }
};