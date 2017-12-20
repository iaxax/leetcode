class Solution {
    public boolean validUtf8(int[] data) {
        int num = data.length;
        int i = 0;

        while (i < num) {
            int ones = headOne(data[i]);
            if (ones == 0) {
                ++i;
            } else if (ones == 1 || ones > 4 || i + ones > num) {
                return false;
            } else {
                for (int j = 1; j < ones; ++j) {
                    if (data[i + j] < 128 || data[i + j] > 191) return false;
                }
                i = i + ones;
            }
        }
        return true;
    }

    private int headOne(int n) {
        int base = 128, ones = 0;
        while (n >= base && base != 0) {
            n -= base;
            base >>= 1;
            ones += 1;
        }
        return ones;
    }
}
