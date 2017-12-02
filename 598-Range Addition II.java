class Solution {
    public int maxCount(int m, int n, int[][] ops) {
        if (ops.length == 0) return m * n;
        int rowMin = ops[0][0], colMin = ops[0][1];
        int num = ops.length;
        for (int i = 1; i < num; ++i) {
            if (ops[i][0] < rowMin) rowMin = ops[i][0];
            if (ops[i][1] < colMin) colMin = ops[i][1];
        }
        return rowMin * colMin;
    }
}
