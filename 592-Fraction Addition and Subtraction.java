class Solution {
    public String fractionAddition(String expression) {
        char[] expr = expression.toCharArray();
        int[] first = next(expr, 0);
        if (first == null) return "0/1";
        
        int len = expr.length;
        int start = first[0], numerator = first[1], denominator = first[2];
        while (start < len) {
            int[] n = next(expr, start + 1);
            if (n == null) break;
            
            int[] add = add(numerator, denominator, expr[start] == '+' ? n[1] : -n[1], n[2]);
            numerator = add[0];
            denominator = add[1];
            start = n[0];
        }
        
        int lcd = lcd(Math.abs(numerator), denominator);
        numerator /= lcd;
        denominator /= lcd;
        return numerator + "/" + denominator;
    }
    
    private int[] next(char[] expression, int start) {
        if (start == expression.length) return null;
        
        boolean positive = true;
        if (expression[start] == '-') {
            positive = false;
            ++start;
        }
        
        int len = expression.length, numerator = 0;
        while (start < len && expression[start] != '/') {
            numerator = numerator * 10 + expression[start++] - '0';
        }
        
        int denominator = 0;
        ++start;
        while (start < len && expression[start] >= '0' && expression[start] <= '9') {
            denominator = denominator * 10 + expression[start++] - '0';
        }
        
        int[] result = { start, positive ? numerator : -numerator, denominator }; 
        return result;
    }
    
    private int[] add(int n1, int d1, int n2, int d2) {
        int lcd = lcd(d1, d2);
        int lcm = d1 * d2 / lcd;
        
        int[] result = new int[2];
        result[0] = n1 * (lcm / d1) + n2 * (lcm / d2);
        result[1] = lcm;
        return result;
    }
    
    private int lcd(int a, int b) {
        return a % b == 0 ? b : lcd(b, a % b);
    }
}
