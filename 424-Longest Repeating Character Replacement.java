class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[128];
        int len = s.length();
        int start = 0, max = 0;
        for (int end = 0; end < len; ++end) {
            max = Math.max(max, ++count[s.charAt(end)]);
            if (end - start + 1 - max > k) {
                --count[s.charAt(start++)];
            }
        }
        return len - start;
    }
}
