class Solution {
public:
    int reverse(int x) {
        int absx = abs(x);
        int result = 0;
        long lresult = 0;
        while (absx > 0) {
            lresult = lresult * 10 + (absx % 10);
            if (lresult > (long)numeric_limits<int>::max()) {
                return 0;
            }
            
            result = result * 10 + (absx % 10);
            absx /= 10;
        }
        
        return x < 0 ? -result : result;
    }
};