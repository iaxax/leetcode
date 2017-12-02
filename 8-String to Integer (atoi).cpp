class Solution {
public:
    int myAtoi(string str) {
        int result = 0;
        long lresult = 0;
        int len = str.size();
        if (len == 0) return 0;
        
        int i = 0;
        while (i < len && isspace(str[i])) ++i;
        if (i >= len) return 0;
        
        bool negative;
        if (str[i] == '-' || str[i] == '+') {
            negative = str[i] == '-';
            i = i + 1;
        }
        else if (str[i] >= '0' && str[i] <= '9') {
            negative = false;
        }
        else {
            return 0;
        }
        
        for (; i < len; ++i) {
           if (str[i] >= '0' && str[i] <= '9') {
               lresult = lresult * 10 + (str[i] - '0');
               if (lresult > (long)numeric_limits<int>::max()) {
                   return negative ? -numeric_limits<int>::max() - 1 : numeric_limits<int>::max();
               }
               result = result * 10 + (str[i] - '0');
           } 
           else {
               return negative ? -result : result;;
           }
        }
        
        return negative ? -result : result;
    }
};