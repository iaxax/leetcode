class Solution {
    public int findCircleNum(int[][] M) {
        int len = M.length;
        int[] unionFind = new int[len];
        for (int i = 0; i < len; ++i) {
            unionFind[i] = i;
        }
        
        for (int i = 0; i < len; ++i) {
            for (int j = 0; j < len; ++j) {
                if (M[i][j] == 1) {
                    join(unionFind, i, j);
                }
            }
        }
        
        int count = 0;
        for (int i = 0; i < len; ++i) {
            if (unionFind[i] == i) ++count;
        }
        return count;
    }
    
    private void join(int[] unionFind, int i, int j) {
        int r1 = find(unionFind, i);
        int r2 = find(unionFind, j);
        if (r1 != r2) {
            unionFind[r1] = r2;
        }
    }
    
    private int find(int[] unionFind, int i) {
        int r = i;
        while (r != unionFind[r]) r = unionFind[r];
        
        int n = i;
        while (n != unionFind[n]) {
            int next = unionFind[n];
            unionFind[n] = r;
            n = next;
        }
        
        return r;
    }
}
