public class Solution {
    public String toHex(int num) {
        if (num == 0) return "0";
        
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(convert(num & 15));
            num >>>= 4;
        }

        return sb.reverse().toString();
    }
    
    private char convert(int digit) {
        return digit < 10 ? (char)(digit + '0') : (char)(digit - 10 + 'a');
    }
}
