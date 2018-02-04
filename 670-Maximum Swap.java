class Solution {
    public int maximumSwap(int num) {
        if (num == 0) return 0;
        
        char[] bits = Integer.toString(num).toCharArray();
        int len = bits.length, index = 0;
        while (index + 1 < len && bits[index] >= bits[index + 1]) ++index;
        if (index == len - 1) return num;
        
        int max = index + 1;
        for (int i = index + 2; i < len; ++i) {
            if (bits[i] >= bits[max]) max = i;
        }
        
        int min = 0;
        for (; min < len && bits[min] >= bits[max]; ++min);
        
        char temp = bits[max];
        bits[max] = bits[min];
        bits[min] = temp;
        
        int result = 0;
        for (int i = 0; i < len; ++i) {
            result = result * 10 + bits[i] - '0';
        }
        return result;
    }
}
