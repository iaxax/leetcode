public class Solution {
    public int findNthDigit(int n) {
        int num = n, digit = 1, start = 1;
        long base = 9;
        while (num > base * digit) {
            num -= base * digit;
            base *= 10;
            digit += 1;
            start *= 10;
        }
        
        start += (num - 1) / digit;
        String s = Integer.toString(start);
        return Character.getNumericValue(s.charAt((num - 1) % digit));
    }
}
