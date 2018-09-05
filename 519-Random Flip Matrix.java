class Solution {
    
    private int n, n_rows, n_cols;
    
    private Random rand = new Random();
    
    private Map<Integer, Integer> map = new HashMap<>();

    public Solution(int n_rows, int n_cols) {
        this.n_rows = n_rows;
        this.n_cols = n_cols;
        this.n = n_rows * n_cols;
    }
    
    public int[] flip() {
        int i = rand.nextInt(n--);
        int x = map.getOrDefault(i, i);
        map.put(i, map.getOrDefault(n, n));
        return new int[] {x / n_cols, x % n_cols};
    }
    
    public void reset() {
        map.clear();
        n = n_rows * n_cols;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(n_rows, n_cols);
 * int[] param_1 = obj.flip();
 * obj.reset();
 */