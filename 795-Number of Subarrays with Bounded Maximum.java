class Solution {
    public int numSubarrayBoundedMax(int[] A, int L, int R) {
        int num = 0;
        int start = 0, bounded = -1;
        for (int i = 0; i < A.length; ++i) {
            if (A[i] < L) {
                if (bounded != -1) num += bounded - start + 1;
            } else if (A[i] <= R) {
                num += i - start + 1;
                bounded = i;
            } else {
                start = i + 1;
                bounded = -1;
            }
        }
        return num;
    }
}