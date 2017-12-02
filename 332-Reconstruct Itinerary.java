class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for (String[] pair : tickets) {
            map.computeIfAbsent(pair[0], k -> new PriorityQueue<>()).add(pair[1]);
        }
        
        List<String> path = new LinkedList<>();
        visit(map, path, "JFK");
        return path;
    }
    
    private void visit(Map<String, PriorityQueue<String>> map, List<String> path, String airpot) {
        PriorityQueue<String> pq = map.getOrDefault(airpot, new PriorityQueue<>());
        while (pq.size() > 0) {
            visit(map, path, pq.poll());
        }
        path.add(0, airpot);
    }
}
