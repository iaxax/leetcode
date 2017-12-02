class Solution {
    
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0) return 1;
        int result = 10, base = 81;
        for (int i = 1; i < n; ++i) {
            result += base;
            base *= 9 - i;
        }
        return result;
    }
}
