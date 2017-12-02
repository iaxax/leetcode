class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        result[0] = 0;
        for (int i = 1; i <= num; ++i) {
            if (result[i] == 0) {
                result[i] = count(i);
                for (int j = i << 1; j <= num; j <<= 1) {
                    result[j] = result[i];
                }
            }
        }
        return result;
    }
    
    private int count(int n) {
        int result = 0;
        while (n != 0) {
            result += n & 1;
            n >>>= 1;
        }
        return result;
    }
}
