class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>(k, (a, b) -> {
            int num1 = a.getValue(), num2 = b.getValue();
            return num1 == num2 ? b.getKey().compareTo(a.getKey()) : num1 - num2;
        });
        
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            minHeap.offer(entry);
            if (minHeap.size() > k) minHeap.poll();
        }
        
        LinkedList<String> result = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            result.addFirst(minHeap.poll().getKey());
        }
        return result;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.entrySet());
        Collections.sort(list, (a, b) -> {
            int num1 = a.getValue(), num2 = b.getValue();
            return num1 == num2 ? a.getKey().compareTo(b.getKey()) : num2 - num1;
        });
        
        List<String> result = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            result.add(list.get(i).getKey());
        }
        return result;
    }
}

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String w : words) {
            count.put(w, count.getOrDefault(w, 0) + 1);
        }
        
        List<String>[] arr = new List[words.length + 1];
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            int num = entry.getValue();
            if (arr[num] == null) arr[num] = new ArrayList<>();
            arr[num].add(entry.getKey());
        }

        List<String> result = new ArrayList<>(k);
        for (int i = words.length; i >= 0 && k > 0; --i) {
            if (arr[i] != null) {
                Collections.sort(arr[i]);
                if (k >= arr[i].size()) {
                    result.addAll(arr[i]);
                    k -= arr[i].size();
                } else {
                    for (int j = 0; j < k; ++j) {
                        result.add(arr[i].get(j));
                    }
                    break;
                }
            }
        }
        return result;
    }
}
