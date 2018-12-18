class Solution {
    public int monotoneIncreasingDigits(int N) {
        String str = String.valueOf(N);
        int i = 0, n = str.length();
        while (i + 1 < n && str.charAt(i) <= str.charAt(i + 1)) {
            i = i + 1;
        }
        if (i + 1 == n) {
            return N;
        }
        
        while (i - 1 >= 0 && str.charAt(i) == str.charAt(i - 1)) {
            i = i - 1;
        }
        if (str.charAt(i) == '1') {
            return (int)(Math.pow(10, n - 1) - 1);
        }
        
        StringBuilder result = new StringBuilder(n);
        result.append(str.substring(0, i));
        result.append((char)(str.charAt(i) - 1));
        i = i + 1;
        while (i < n) {
            result.append('9');
            i = i + 1;
        }
        return Integer.parseInt(result.toString());
    }
}

class Solution {
    public int monotoneIncreasingDigits(int N) {
        char[] digits = String.valueOf(N).toCharArray();
        int n = digits.length;
        int mark = n;
        for (int i = n - 1; i > 0; --i) {
            if (digits[i] < digits[i - 1]) {
                digits[i - 1] -= 1;
                mark = i;
            }
        }
        for (int i = mark; i < n; ++i) {
            digits[i] = '9';
        }
        return Integer.parseInt(new String(digits));
    }
}