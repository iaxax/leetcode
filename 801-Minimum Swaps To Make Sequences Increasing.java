class Solution {
    public int minSwap(int[] A, int[] B) {
        int n = A.length;
        int idle = 0, swap = 1;
        
        for (int i = 1; i < n; ++i) {
            if (A[i] <= A[i - 1] || B[i] <= B[i - 1]) {
                int temp = idle;
                idle = swap;
                swap = temp + 1;
            } else if (A[i] > B[i - 1] && B[i] > A[i - 1]){
                int m = Math.min(swap, idle);
                idle = m;
                swap = m + 1;
            } else {
                swap = swap + 1;
            }
        }
        return Math.min(idle, swap);
    }
}