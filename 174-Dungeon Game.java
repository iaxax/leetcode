public class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int row = dungeon.length;
        int col = dungeon[0].length;
        
        int[][] cost = new int[row][col];
        cost[row - 1][col - 1] = dungeon[row - 1][col - 1] >= 0 ? 1 : -dungeon[row - 1][col - 1] + 1;
        for (int i = row - 1; i >= 0; --i) {
            for (int j = col - 1; j >= 0; --j) {
                if (i == row - 1 && j == col - 1) {
                    continue;
                }
                
                cost[i][j] = Integer.MAX_VALUE;
                
                if (i + 1 <= row - 1) {
                    cost[i][j] = cost[i + 1][j];
                }
                
                if (j + 1 <= col - 1) {
                    cost[i][j] = Math.min(cost[i][j], cost[i][j + 1]);
                }
                
                cost[i][j] -= dungeon[i][j];
                if (cost[i][j] <= 0) {
                    cost[i][j] = 1;
                }
            }
        }
        
        return cost[0][0] == 0 ? 1 : cost[0][0];
    }
}