class Solution {
    public int minMutation(String start, String end, String[] bank) {
        HashMap<String, HashSet<String>> graph = buildGraph(bank, start);
        return search(graph, new HashSet<>(), start, end);
    }
    
    private int search(HashMap<String, HashSet<String>> graph, HashSet<String> visited, String start, String end) {
        if (visited.contains(start)) {
            return -1;
        }
        visited.add(start);
        
        HashSet<String> next = graph.getOrDefault(start, new HashSet<>());
        if (next.contains(end)) {
            visited.remove(start);
            return 1;
        }
        
        int step = Integer.MAX_VALUE;
        boolean hasPath = false;
        for (String n : next) {
            int s = search(graph, visited, n, end);
            if (s != -1) {
                step = Math.min(step, 1 + s);
                hasPath = true;
            }
        }
        
        visited.remove(start);
        return hasPath ? step : -1;
    }
    
    private HashMap<String, HashSet<String>> buildGraph(String[] bank, String start) {
        HashMap<String, HashSet<String>> graph = new HashMap<>();
        int n = bank.length;
        for (int i = 0; i < n; ++i) {
            HashSet<String> set = graph.getOrDefault(bank[i], new HashSet<>());
            for (int j = i + 1; j < n; ++j) {
                if (oneMutation(bank[i], bank[j])) {
                    set.add(bank[j]);
                    HashSet<String> s = graph.getOrDefault(bank[j], new HashSet<>());
                    s.add(bank[i]);
                    graph.put(bank[j], s);
                }
            }
            graph.put(bank[i], set);
        }
        
        HashSet<String> set = graph.get(start);
        if (set == null) {
            set = new HashSet<>();
            for (int i = 0; i < n; ++i) {
                if (oneMutation(start, bank[i])) {
                    set.add(bank[i]);
                }
            }
            graph.put(start, set);
        }

        return graph;
    }
    
    private boolean oneMutation(String from, String to) {
        int m = from.length(), n = to.length();
        if (m != n) {
            return false;
        }
        
        int diff = 0;
        for (int i = 0; i < m; ++i) {
            if (from.charAt(i) != to.charAt(i)) {
                diff = diff + 1;
            }
            if (diff > 1) {
                return false;
            }
        }
        return diff == 1;
    }
}