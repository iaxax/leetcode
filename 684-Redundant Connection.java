class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] ufs = init(edges.length + 1);
        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            if (!union(ufs, a, b)) {
                return edge;
            }
        }
        return null;
    }
    
    private int[] init(int n) {
        int[] ufs = new int[n];
        Arrays.fill(ufs, -1);
        return ufs;
    }
    
    private int find(int[] ufs, int i) {
        while (ufs[i] != -1) {
            i = ufs[i];
        }
        return i;
    }
    
    private boolean union(int[] ufs, int i, int j) {
        int r1 = find(ufs, i), r2 = find(ufs, j);
        if (r1 == r2) {
            return false;
        }
        ufs[r1] = r2;
        return true;
    }
}