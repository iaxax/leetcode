class Solution {
    public boolean escapeGhosts(int[][] ghosts, int[] target) {
        int distance = calculateDistance(0, 0, target[0], target[1]);
        for (int[] g : ghosts) {
            if (distance >= calculateDistance(g[0], g[1], target[0], target[1])) {
                return false;
            }
        }
        return true;
    }
    
    private int calculateDistance(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) + Math.abs(c1 - c2);
    }
}