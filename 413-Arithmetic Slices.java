class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int i = 0, size = A.length;
        int num = 0;
        while (i + 2 < size) {
            int j = i;
            while (j + 2 < size && (A[j + 1] - A[j] == A[j + 2] - A[j + 1])) {
                ++j;
            }
            if (i == j) {
                i = i + 1;
            } else {
                num += (j - i) * (j - i + 1) / 2;
                i = j + 2;
            }
        }
        return num;
    }
}
