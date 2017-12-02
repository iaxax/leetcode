public class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int firstOne = -1;
        int mm = m;
        for (int i = 0; i < 31; ++i) {
            if ((mm & 1) != 0) firstOne = i + 1;
            mm >>= 1;
        }
        
        if (firstOne == -1) {
            return 0;
        }
        
        if ((long)n >= (long)Math.pow(2, firstOne)) {
            return 0;
        }
        
        int result = -1;
        for (long i = m; i <= n; ++i) {
            result &= (int)i;
        }
        return result;
    }
}