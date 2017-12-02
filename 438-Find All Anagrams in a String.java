public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] map = new int[26];
        for (char c : p.toCharArray()) {
            map[c - 'a'] += 1;
        }
        
        int left = 0, right = 0, slen = s.length();
        List<Integer> result = new LinkedList<>();
        int plen = p.length();
        int count = plen;
        while (right < slen) {
            if (map[s.charAt(right++) - 'a']-- >= 1) --count;
            if (count == 0) result.add(left);
            if (right - left == plen && map[s.charAt(left++) - 'a']++ >= 0) ++count;
        }
        return result;
    }
}
