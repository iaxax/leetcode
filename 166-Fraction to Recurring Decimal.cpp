class Solution {
public:
    string fractionToDecimal(int numerator, int denominator) {
        if (denominator == 0) {
            return "0";
        }
        
        string result = "";
        result += ((numerator > 0 && denominator > 0 || numerator < 0 && denominator < 0 || numerator == 0) ? "" : "-");
        
        long num = labs((long)numerator);
        long den = labs((long)denominator);
        long intPart = num / den;
        result += to_string(intPart);
        
        num %= den;
        if (num == 0) {
            return result;
        }
        
        result += ".";
        unordered_map<long, int> mp;
        mp.insert({num, result.size()});
        while (num > 0) {
            num *= 10;
            result += to_string(num / den);
            num %= den;
            if (mp.find(num) != mp.end()) {
                result.insert(result.begin() + mp[num], '(');
                result += ")";
                break;
            }
            else {
                mp.insert({num, result.size()});
            }
        }
        
        return result;
    }
    
};