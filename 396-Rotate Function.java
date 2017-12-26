class Solution {
    public int maxRotateFunction(int[] A) {
        int len = A.length;
        int sum = 0, F = 0;
        for (int i = 0; i < len; ++i) {
            sum += A[i];
            F += i * A[i];
        }
        
        int maxF = F;
        for (int i = 1; i < len; ++i) {
            F = F - sum + len * A[i - 1];
            maxF = Math.max(maxF, F);
        }
        return maxF;   
    }
}
