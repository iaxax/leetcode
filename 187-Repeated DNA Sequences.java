public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i <= s.length() - 10; ++i) {
            String str = s.substring(i, i + 10);
            if (map.containsKey(str)) {
                map.put(str, map.get(str).intValue() + 1);
            }
            else {
                map.put(str, 1);
            }
        }
        
        List<String> result = new LinkedList<>();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                result.add(entry.getKey());
            }
        }
        return result;
    }
}