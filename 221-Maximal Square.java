// O(n^2) Solution
class Solution {
    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        if (col == 0) return 0;
        
        int maxSquare = 0;
        int[] heights = new int[col + 1];
        for (int i = 0; i < row; ++i) {
            int s = maximalSquare(matrix, i, heights);
            if (s > maxSquare) maxSquare = s;
        }
        return maxSquare;
    }
    
    private int maximalSquare(char[][] matrix, int row, int[] heights) {
        int col = heights.length;
        int maxSquare = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < col; ++i) {
            if (i < matrix[0].length) {
                heights[i] = matrix[row][i] == '0' ? 0 : heights[i] + 1;
            }
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                int h = heights[stack.pop()];
                int l = stack.isEmpty() ? -1 : stack.peek();
                int len = Math.min(h, i - 1 - l);
                if (len * len > maxSquare) maxSquare = len * len;
            }
            stack.push(i);
        }
        return maxSquare;
    }
}

// O(n^2) Solution, faster
class Solution {
    public int maximalSquare(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return 0;
        int row = matrix.length, col = matrix[0].length;
        int[] dp = new int[row + 1];
        int maxSize = 0, pre = 0;
        for (int i = 0; i < col; ++i) {
            for (int j = 0; j < row; ++j) {
                int temp = dp[j + 1];
                if (matrix[j][i] == '1') {
                    dp[j + 1] = Math.min(dp[j + 1], Math.min(dp[j], pre)) + 1;
                    if (dp[j + 1] > maxSize) maxSize = dp[j + 1];
                }
                else {
                    dp[j + 1] = 0;
                }
                pre = temp;
            }
        }
        return maxSize * maxSize;
    }
}
