class Solution {
    public String reorganizeString(String S) {
        int[] count = new int[26];
        for (char c : S.toCharArray()) {
            count[c - 'a'] += 1;
        }
        
        List<Pair> pairs = new ArrayList<>(26);
        for (int i = 0; i < 26; ++i) {
            if (count[i] > 0) {
                pairs.add(new Pair((char)(i + 'a'), count[i]));
            }
        }
        Collections.sort(pairs);
        
        char[] sorted = new char[S.length()];
        int index = 0;
        for (Pair p : pairs) {
            char c = p.c;
            for (int j = 0; j < p.count; ++j) {
                sorted[index] = c;
                index += 1;
            }
        }
        
        int gap = pairs.size();
        int step = pairs.get(0).count;
        char[] buffer = new char[step * gap];
        index = 0;
        for (int i = 0; i < gap; ++i) {
            for (int j = i; j < buffer.length && index < S.length(); j += gap) {
                buffer[j] = sorted[index];
                index += 1;
            }
        }
        
        StringBuilder sbuilder = new StringBuilder(S.length());
        for (int i = 0;;) {
            while (i < buffer.length && buffer[i] == 0) ++i;
            if (i == buffer.length) break;
            if (sbuilder.length() > 0 && sbuilder.charAt(sbuilder.length() - 1) == buffer[i]) {
                return "";
            } else {
                sbuilder.append(buffer[i++]);
            }
        }
        return sbuilder.toString();
    }
    
    private static class Pair implements Comparable<Pair> {
        char c;
        int count;
        Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
        
        public int compareTo(Pair p) {
            return p.count - count;
        }
    }
}