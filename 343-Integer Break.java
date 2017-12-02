class Solution {
    public int integerBreak(int n) {
        int maxProduct = 0;
        for (int i = 2; i <= n; ++i) {
            int piece = n / i;
            int remain = n % i;
            int p = 1;
            for (int j = 0; j < remain; ++j) {
                p *= (piece + 1);
            }
            for (int j = remain; j < i; ++j) {
                p *= piece;
            }
            if (p > maxProduct) maxProduct = p;
        }
        return maxProduct;
    }
}
