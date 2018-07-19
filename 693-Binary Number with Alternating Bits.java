class Solution {
    public boolean hasAlternatingBits(int n) {
        int[] bits = {0, 1};
        int index = n % 2;
        while (n > 0) {
            if ((n & 1) != bits[index]) {
                return false;
            }
            n >>= 1;
            index = (index + 1) % 2;
        }
        return true;
    }
}