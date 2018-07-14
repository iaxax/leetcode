// brute-force
class Solution {
    public boolean checkValidString(String s) {
        return checkValidString(s.toCharArray(), 0, 0);
    }
    
    private boolean checkValidString(char[] str, int leftNum, int start) {
        if (start == str.length) {
            return leftNum == 0;
        }
        
        char c = str[start];
        switch(c) {
            case '(':
                return checkValidString(str, leftNum + 1, start + 1);
            case ')':
                if (leftNum == 0) return false;
                return checkValidString(str, leftNum - 1, start + 1);
            case '*':
                if (checkValidString(str, leftNum, start + 1)) return true;
                
                if (leftNum == 0) {
                    return checkValidString(str, leftNum + 1, start + 1);
                } else {
                    if (checkValidString(str, leftNum - 1, start + 1)) return true;
                    return checkValidString(str, leftNum + 1, start + 1);
                }
        }
        
        // just for syntax, out of reach
        return false;
    }
}

// O(n)
class Solution {
    public boolean checkValidString(String s) {
        int low = 0, high = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                ++low; ++high;
            } else if (c == ')') {
                if (low > 0) --low;
                --high;
            } else {
                if (low > 0) --low;
                ++high;
            }
            if (high < 0) return false;
        }
        return low == 0;
    }
}
