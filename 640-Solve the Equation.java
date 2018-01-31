class Solution {
    public String solveEquation(String equation) {
        String[] eq = equation.split("=");
        int[] left = simplify(eq[0]), right = simplify(eq[1]);
        int k = left[0] - right[0], b = right[1] - left[1];
        if (k == 0) {
            return b == 0 ? "Infinite solutions" : "No solution";
        } else {
            return "x=" + (b / k);
        }
    }
    
    private int[] simplify(String expr) {
        int[] first = next(expr, 0);
        int k = first[2] == 1 ? 0 : first[1];
        int b = first[2] == 1 ? first[1] : 0;
        int start = first[0], len = expr.length();
        while (start < len) {
            int[] n = next(expr, start + 1);
            if (n == null) break;
            if (n[2] == 1) {
                b = expr.charAt(start) == '+' ? b + n[1] : b - n[1];
            } else {
                k = expr.charAt(start) == '+' ? k + n[1] : k - n[1];
            }
            start = n[0];
        }
        return new int[] {k, b};
    }
    
    private int[] next(String expr, int start) {
        int len = expr.length();
        if (start == len) return null;
        
        char[] arr = expr.toCharArray();
        boolean positive = true;
        if (arr[start] == '-') {
            positive = false;
            ++start;
        }
        
        if (arr[start] == 'x') {
            return new int[] {start + 1, positive ? 1 : -1, 0};
        }
        
        int value = 0;
        while (start < len && arr[start] >= '0' && arr[start] <= '9') {
            value = value * 10 + arr[start++] - '0';
        }
        
        if (start < len && arr[start] == 'x') {
            return new int[] {start + 1, positive ? value : -value, 0};
        }
        
        return new int[] {start, positive ? value : -value, 1};
    }
}
