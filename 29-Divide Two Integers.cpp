class Solution {
public:
    int divide(int dividend, int divisor) {
        int maxInt = numeric_limits<int>::max();
        int minInt = numeric_limits<int>::min();
        if (divisor == 0 || dividend == minInt && divisor == -1) {
            return maxInt;
        }
        
        bool positive = dividend > 0 && divisor > 0 || dividend < 0 && divisor < 0;
        long a = labs(dividend);
        long b = labs(divisor);
        int result = 0;
        while (a >= b) {
            long temp = b;
            int mul = 1;
            while (a >= (temp << 1)) {
                temp = temp << 1;
                mul = mul << 1;
            }
            
            a -= temp;
            result += mul;
        }
        return positive ? result : -result;
    }
};