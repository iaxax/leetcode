public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int weight = 0;
        for (int i = 0; i < 31; ++i) {
            weight += n & 1;
            n >>= 1;
        }
        return weight + (n & 1);
    }
}