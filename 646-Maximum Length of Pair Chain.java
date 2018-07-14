class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, (p1, p2) -> p1[1] - p2[1]);
        int end = pairs[0][1], len = pairs.length;
        int chain = 1;
        for (int i = 1; i < len; ++i) {
            if (pairs[i][0] > end) {
                end = pairs[i][1];
                chain += 1;
            }
        }
        return chain;
    }
}
