class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        int m = obstacleGrid.size();
        if (m == 0) return 0;
        int n = obstacleGrid[0].size();
        if (n == 0) return 0;
        
        int paths[100][100];
        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < m; ++i) {
            paths[i][0] = obstacleGrid[i][0] == 1 || paths[i - 1][0] == 0 ? 0 : 1;
        }
        for (int i = 1; i < n; ++i) {
            paths[0][i] = obstacleGrid[0][i] == 1 || paths[0][i - 1] == 0 ? 0 : 1;
        }
        
        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                paths[i][j] = obstacleGrid[i][j] == 1 ? 0 : paths[i - 1][j] + paths[i][j - 1];
            }
        }
        
        return paths[m - 1][n - 1];
    }
};