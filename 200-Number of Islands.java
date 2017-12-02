public class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) return 0;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                visited[i][j] = false;
            }
        }
        
        int num = 0;
        for (int i = 0; i < row; ++i) {
            for (int j = 0; j < col; ++j) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    visite(visited, grid, i, j, row, col);
                    num += 1;
                }
            }
        }
        
        return num;
    }
    
    private void visite(boolean[][] visited, char[][] grid, int i, int j, int row, int col) {
        if (i >= 0 && i < row && j >= 0 && j < col && !visited[i][j] && grid[i][j] == '1') {
            visited[i][j] = true;
            visite(visited, grid, i + 1, j, row, col);
            visite(visited, grid, i - 1, j, row, col);
            visite(visited, grid, i, j + 1, row, col);
            visite(visited, grid, i, j - 1, row, col);
        }
    }
}