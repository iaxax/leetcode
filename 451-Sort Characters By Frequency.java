// O(nlogn) solution
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            pq.offer(new Pair(entry.getKey(), entry.getValue()));
        }
        
        StringBuilder result = new StringBuilder(s.length());
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            for (int i = 0; i < p.count; ++i) {
                result.append(p.c);
            }
        }
        return result.toString();
    }
    
    private class Pair implements Comparable<Pair> {
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

// O(n) solution
class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> count = new HashMap<>();
        int maxCount = 0;
        for (char c : s.toCharArray()) {
            int n = count.getOrDefault(c, 0) + 1;
            maxCount = Math.max(maxCount, n);
            count.put(c, n);
        }
        
        HashSet<Character>[] set = new HashSet[maxCount + 1];
        for (Map.Entry<Character, Integer> entry : count.entrySet()) {
            char c = entry.getKey();
            int n = entry.getValue();
            if (set[n] == null) {
                set[n] = new HashSet<>();
            }
            set[n].add(c);
        }
        
        StringBuilder result = new StringBuilder(s.length());
        for (int i = maxCount; i > 0; --i) {
            if (set[i] != null) {
                for (char c : set[i]) {
                    for (int j = 0; j < i; ++j) {
                        result.append(c);
                    }
                }
            }
        }
        return result.toString();
    }
}
