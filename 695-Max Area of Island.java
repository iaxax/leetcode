class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int area = 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                area = Math.max(area, search(grid, visited, i, j));
            }
        }
        return area;
    }
    
    private int search(int[][] grid, boolean[][] visited, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j] || grid[i][j] == 0) {
            return 0;
        }
        
        visited[i][j] = true;
        int area = 1;
        area += search(grid, visited, i + 1, j);
        area += search(grid, visited, i - 1, j);
        area += search(grid, visited, i, j + 1);
        area += search(grid, visited, i, j - 1);
        return area;
    }
}