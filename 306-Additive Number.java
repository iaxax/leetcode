class Solution {
    public boolean isAdditiveNumber(String num) {
        int n = num.length();
        for (int i = 0; i <= n >> 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int one = 0, two = 0;
                try {
                    one = Integer.valueOf(num.substring(0, i + 1));
                    two = Integer.valueOf(num.substring(i + 1, j + 1));
                }
                catch (Exception e) {
                    break;
                }
                
                String three = num.substring(j + 1);
                if (isAdditiveNumber(three, one, two)) {
                    return true;
                }
                if (num.charAt(i + 1) == '0') {
                    break;
                }
            }
            if (num.charAt(0) == '0') {
                break;
            }
        }
        return false;
    }
    
    private boolean isAdditiveNumber(String num, long one, long two) {
        String sum = String.valueOf(one + two);
        if (num.indexOf(sum) == 0) {
            if (sum.length() == num.length()) {
                return true;
            }
            else {
                return isAdditiveNumber(num.substring(sum.length()), two, one + two);
            }
        }
        return false;
    }
}
