class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int len = strs.length;
        if (len == 0 || m < 0 || n < 0) return 0;
        
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= len; ++i) {
            int[] num = numOfZeroAndOne(strs[i - 1]);
            for (int j = m; j >= 0; --j) {
                for (int k = n; k >= 0; --k) {
                    if (j >= num[0] && k >= num[1]) {
                        dp[j][k] = Math.max(dp[j - num[0]][k - num[1]] + 1, dp[j][k]);
                    }
                }
            }
        }
        
        return dp[m][n];
    }
    
    private int[] numOfZeroAndOne(String str) {
        int[] num = new int[2];
        for (char c : str.toCharArray()) {
            num[0] += c == '0' ? 1 : 0;
            num[1] += c == '1' ? 1 : 0;
        }
        return num;
    }
}
