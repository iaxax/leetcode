class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0, n = bits.length;
        while (i < n) {
            if (i + 1 == n) {
                return true;
            }
            i += bits[i] == 0 ? 1 : 2;
        }
        return false;
    }
}