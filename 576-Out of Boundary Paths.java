class Solution {
        public int findPaths(int m, int n, int N, int i, int j) {
            if (N == 0) return 0;

            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(i * n + j, 1);

            int paths = 0;
            int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int k = 0; k < N; ++k) {
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int pos = entry.getKey();
                    int r = pos / n, c = pos % n;
                    if (r == 0) paths = (paths + entry.getValue()) % 1000000007;
                    if (r == m - 1) paths = (paths + entry.getValue()) % 1000000007;
                    if (c == 0) paths = (paths + entry.getValue()) % 1000000007;
                    if (c == n - 1) paths = (paths + entry.getValue()) % 1000000007;
                }
                
                if (k == N - 1) break;

                HashMap<Integer, Integer> temp = new HashMap<>();
                for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
                    int pos = entry.getKey();
                    int r = pos / n, c = pos % n;
                    for (int[] d : dir) {
                        int rr = r + d[0], cc = c + d[1];
                        if (rr >= 0 && rr < m && cc >= 0 && cc < n) {
                            temp.put(rr * n+ cc, (temp.getOrDefault(rr * n + cc, 0) + entry.getValue()) % 1000000007);
                        }
                    }
                }
                map = temp;
            }
            return paths;
        }
}

class Solution {
    public int findPaths(int m, int n, int N, int i, int j) {
        int[][][] dp = new int[N + 1][m][n];
        for (int a = 1; a <= N; ++a) {
            for (int b = 0; b < m; ++b) {
                for (int c = 0; c < n; ++c) {
                    dp[a][b][c] = (dp[a][b][c] + (b == 0 ? 1 : dp[a - 1][b - 1][c])) % 1000000007;
                    dp[a][b][c] = (dp[a][b][c] + (b == m - 1 ? 1 : dp[a - 1][b + 1][c])) % 1000000007;
                    dp[a][b][c] = (dp[a][b][c] + (c == 0 ? 1 : dp[a - 1][b][c - 1])) % 1000000007;
                    dp[a][b][c] = (dp[a][b][c] + (c == n - 1 ? 1 : dp[a - 1][b][c + 1])) % 1000000007;
                }
            }
        }
        return dp[N][i][j];
    }
}
