class Solution {
    public int magicalString(int n) {
        if (n == 0) return 0;
        if (n <= 3) return 1;
        
        char[] str = new char[n];
        str[0] = '1';
        str[1] = '2';
        
        int i = 1, j = 1;
        while (j < n) {
            char next = str[j - 1] == '1' ? '2' : '1';
            if (str[i] == '1') {
                str[j++] = next;
            } else {
                str[j++] = next;
                if (j < n) str[j++] = next;
            }
            ++i;
        }
        
        int count = 0;
        for (char c : str) {
            if (c == '1') count += 1;
        }
        return count;
    }
}
