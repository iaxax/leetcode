class Solution {
    public int kthGrammar(int N, int K) {
        if (N == 0) return 0;
        return (K + kthGrammar(N - 1, (K + 1) >> 1)) % 2 == 0 ? 1 : 0;
    }
}
