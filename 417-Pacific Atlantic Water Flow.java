// slow solution
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) return new ArrayList<>();
        int col = matrix[0].length;

        boolean[][][] dp = new boolean[row][col][2];
        for (int i = 0; i < row; ++i) {
            dp[i][0][0] = dp[i][col - 1][1] = true;
        }
        for (int i = 0; i < col; ++i) {
            dp[0][i][0] = dp[row - 1][i][1] = true;
        }

        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                flow(matrix, dp, visited, i, j, 0);
                flow(matrix, dp, visited, i, j, 1);
            }
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (dp[i][j][0] && dp[i][j][1]) {
                    int[] cord = new int[2];
                    cord[0] = i; cord[1] = j;
                    result.add(cord);
                }
            }
        }

        return result;
    }

    private void flow(int[][] matrix, boolean[][][] dp, boolean[][] visited, int i, int j, int ocean) {
        if (visited[i][j]) return;

        visited[i][j] = true;
        int row = matrix.length;
        int col = matrix[0].length;

        if (i + 1 < row && matrix[i][j] >= matrix[i + 1][j]) {
            if (!dp[i + 1][j][ocean]) {
                flow(matrix, dp, visited, i + 1, j, ocean);
            }
            dp[i][j][ocean] = dp[i][j][ocean] || dp[i + 1][j][ocean];
        }

        if (i - 1 >= 0 && matrix[i][j] >= matrix[i - 1][j]) {
            if (!dp[i - 1][j][ocean]) {
                flow(matrix, dp, visited, i - 1, j, ocean);
            }
            dp[i][j][ocean] = dp[i][j][ocean] || dp[i - 1][j][ocean];
        }

        if (j + 1 < col && matrix[i][j] >= matrix[i][j + 1]) {
            if (!dp[i][j + 1][ocean]) {
                flow(matrix, dp, visited, i, j + 1, ocean);
            }
            dp[i][j][ocean] = dp[i][j][ocean] || dp[i][j + 1][ocean];
        }

        if (j - 1 >= 0 && matrix[i][j] >= matrix[i][j - 1]) {
            if (!dp[i][j - 1][ocean]) {
                flow(matrix, dp, visited, i, j - 1, ocean);
            }
            dp[i][j][ocean] = dp[i][j][ocean] || dp[i][j - 1][ocean];
        }

        visited[i][j] = false;
    }
}

// fast solution
class Solution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        int row = matrix.length;
        if (row == 0) return new ArrayList<>();
        int col = matrix[0].length;

        boolean[][] pacific = new boolean[row][col];
        boolean[][] atlantic = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            flow(matrix, pacific, i, 0, Integer.MIN_VALUE);
            flow(matrix, atlantic, i, col - 1, Integer.MIN_VALUE);
        }
        
        for (int i = 0; i < col; ++i) {
            flow(matrix, pacific, 0, i, Integer.MIN_VALUE);
            flow(matrix, atlantic, row - 1, i, Integer.MIN_VALUE);
        }

        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }

        return result;
    }
    
    private int[][] direc = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    private void flow(int[][] matrix, boolean[][] visited, int i, int j, int height) {
        int row = matrix.length;
        int col = matrix[0].length;
        if (i < 0 || i >= row || j < 0 || j >= col || visited[i][j] || matrix[i][j] < height) return;

        visited[i][j] = true;
        for (int[] d : direc) {
            flow(matrix, visited, i + d[0], j + d[1], matrix[i][j]);
        }
    }
}
