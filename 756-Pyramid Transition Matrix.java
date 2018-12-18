class Solution {
    public boolean pyramidTransition(String bottom, List<String> allowed) {
        HashMap<Integer, Set<Character>> map = new HashMap<>();
        for (String str : allowed) {
            int k = encode(str.charAt(0), str.charAt(1));
            Set<Character> set = map.getOrDefault(k, new HashSet<>());
            set.add(str.charAt(2));
            map.put(k, set);
        }
        return pyramidTransition(map, bottom, new StringBuilder(), 1);
    }
    
    private boolean pyramidTransition(
        HashMap<Integer, Set<Character>> allowed,
        String bottom, StringBuilder next, int index) {
        
        int n = bottom.length();
        if (n == 1) {
            return true;
        }
        if (index == n) {
            return pyramidTransition(allowed, next.toString(), new StringBuilder(), 1);
        }
        
        int k = encode(bottom.charAt(index - 1), bottom.charAt(index));
        Set<Character> set = allowed.get(k);
        if (set == null) {
            return false;
        }
        
        for (char c : set) {
            next.append(c);
            if (pyramidTransition(allowed, bottom, next, index + 1)) {
                return true;
            }
            next.deleteCharAt(next.length() - 1);
        }
        return false;
    }
    
    private int encode(char c, char d) {
        return c * 128 + d;
    }
}
