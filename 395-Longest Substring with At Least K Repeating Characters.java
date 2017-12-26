class Solution {
    public int longestSubstring(String s, int k) {
        if (s.length() < k) return 0;
        
        Map<Character, Integer> countMap = new HashMap<>();
        char[] array = s.toCharArray();
        for (char c : array) {
            if (countMap.containsKey(c)) {
                countMap.put(c, countMap.get(c) + 1);
            } else {
                countMap.put(c, 1);
            }
        }
        
        int i = 0, len = array.length;
        while (i < len && countMap.get(array[i]) >= k) {
            ++i;
        }
        
        int right = i;
        while (right < len && countMap.get(array[right]) < k) {
            ++right;
        }
        
        return i == len ? len : Math.max(
            longestSubstring(s.substring(0, i), k),
            longestSubstring(s.substring(right), k)
        );
    }
}
