class Solution {
    public double largestSumOfAverages(int[] A, int K) {
        int n = A.length;
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; ++i) {
            sum[i + 1] = sum[i] + A[i];
        }
        
        double[][] dp = new double[n + 1][K + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= Math.min(i, K); ++j) {
                for (int k = i - 1; k >= j - 1; --k) {
                    if (k < 1 || dp[k][j - 1] > 0) {
                        double avg = (sum[i] - sum[k]) / ((double)i - k);
                        dp[i][j] = Math.max(dp[i][j], dp[k][j - 1] + avg);
                    }
                }
            }
        }
        return dp[n][K];
    }
}