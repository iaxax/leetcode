class Solution {
    
    public double knightProbability(int N, int K, int r, int c) {
        List<Integer>[] next = computeNextLocations(N);
        double[] probabilities = new double[N * N];
        Arrays.fill(probabilities, 1);
        
        for (int i = 0; i < K; ++i) {
            double[] p = Arrays.copyOf(probabilities, N * N);
            for (int x = 0; x < N; ++x) {
                for (int y = 0; y < N; ++y) {
                    List<Integer> list = next[encode(N, x, y)];
                    probabilities[encode(N, x, y)] = 0.0;
                    for (int loc : list) {
                        probabilities[encode(N, x, y)] += 0.125 * p[loc];
                    }
                }
            }
        }
        return probabilities[encode(N, r, c)];
    }
    
    private List<Integer>[] computeNextLocations(int N) {
        List<Integer>[] next = new List[N * N];
        for (int i = 0; i < N; ++i) {
            for (int j = 0; j < N; ++j) {
                int current = encode(N, i, j);
                List<Integer> list = new ArrayList<>();
                if (i + 2 < N) {
                    if (j + 1 < N) list.add(encode(N, i + 2, j + 1));
                    if (j - 1 >= 0) list.add(encode(N, i + 2, j - 1));
                }
                if (i - 2 >= 0) {
                    if (j + 1 < N) list.add(encode(N, i - 2, j + 1));
                    if (j - 1 >= 0) list.add(encode(N, i - 2, j - 1));
                }
                if (j + 2 < N) {
                    if (i + 1 < N) list.add(encode(N, i + 1, j + 2));
                    if (i - 1 >= 0) list.add(encode(N, i - 1, j + 2));
                }
                if (j - 2 >= 0) {
                    if (i + 1 < N) list.add(encode(N, i + 1, j - 2));
                    if (i - 1 >= 0) list.add(encode(N, i - 1, j - 2));
                }
                next[current] = list;
            }
        }
        return next;
    }
    
    private int encode(int N, int i, int j) {
        return i * N + j;
    }
}

class Solution {
    
    public double knightProbability(int N, int K, int r, int c) {
        double[][] probabilities = new double[N][N];
        for (int i = 0; i < N; ++i) {
            Arrays.fill(probabilities[i], 1);
        }
        
        int[][] directions = {{1, 2}, {-1, 2}, {1, -2}, {-1, -2}, {2, 1}, {2, -1}, {-2, 1}, {-2, -1}};
        for (int i = 0; i < K; ++i) {
            double[][] p = new double[N][N];
            for (int x = 0; x < N; ++x) {
                for (int y = 0; y < N; ++y) {
                    for (int[] d : directions) {
                        if (isInBound(N, x + d[0], y + d[1])) {
                            p[x][y] += 0.125 * probabilities[x + d[0]][y + d[1]];
                        }
                    }
                }
            }
            probabilities = p;
        }
        return probabilities[r][c];
    }
    
    private boolean isInBound(int N, int i, int j) {
        return i >= 0 && i < N && j >= 0 && j < N;
    }
}