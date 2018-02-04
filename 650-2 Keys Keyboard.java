class Solution {
    public int minSteps(int n) {
        return n == 1 ? 0 : 1 + minSteps(n, 0, 1);
    }
    
    private int minSteps(int n, int current, int copy) {
        if (current == n) return 0;
        if (current > n) return n + 1;
        
        int steps = 1 + minSteps(n, current + copy, copy);
        return Math.min(steps, 2 + minSteps(n, current << 1, current));
    }
}
