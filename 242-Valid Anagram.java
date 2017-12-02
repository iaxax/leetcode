public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map1 = count(s), map2 = count(t);
        return map1.equals(map2);
    }
    
    private Map<Character, Integer> count(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            }
            else {
                map.put(c, 1);
            }
        }
        return map;
    }
}
