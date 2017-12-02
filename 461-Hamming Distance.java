public class Solution {
    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int[] num = {0, 1, 1, 2};
        int distance = 0;
        while (xor != 0) {
            distance += num[xor & 3];
            xor >>>= 2;
        }
        return distance;
    }
}
