class Solution {
    public int compress(char[] chars) {
        int length = 0;
        int n = chars.length;
        for (int i = 0; i < n; ++i) {
            int k = i;
            while (i + 1 < n && chars[i + 1] == chars[i]) ++i;
            if (i - k >= 1) {
                chars[length++] = chars[k];
                
                int count = i - k + 1;
                StringBuilder builder = new StringBuilder();
                while (count > 0) {
                    builder.append(count % 10);
                    count /= 10;
                }
                
                String str = builder.toString();
                for (int j = str.length() - 1; j >= 0; --j) {
                    chars[length++] = str.charAt(j);
                }
            } else {
                chars[length++] = chars[k];
            }
        }
        return length;
    }
}