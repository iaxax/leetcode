class Solution {
    
    private static class Entry implements Comparable<Entry> {
        int key, value;
        Entry(int k, int v) {
            key = k; value = v;
        }
        public int compareTo(Entry e) {
            return e.value - value;
        }
    }
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int index = 0;
        Entry[] arr = new Entry[map.size()];
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            arr[index] = new Entry(e.getKey(), e.getValue());
            index += 1;
        }
        partition(arr, k);
        
        List<Integer> result = new ArrayList<>(k);
        for (int i = 0; i < k; ++i) {
            result.add(arr[i].key);
        }
        return result;
    }
    
    private void partition(Entry[] arr, int k) {
        int start = 0, end = arr.length - 1;
        while (start < end) {
            int i = partition(arr, start, end);
            if (i > k - 1) {
                end = i - 1;
            }
            else if (i < k - 1) {
                start = i + 1;
            }
            else {
                break;
            }
        }
    }
    
    private int partition(Entry[] arr, int start, int end) {
        int i = start, j = end + 1;
        while (true) {
            while (i < end && arr[++i].value > arr[start].value);
            while (j > start && arr[--j].value < arr[start].value);
            if (i >= j) break;
            swap(arr, i, j);
        }
        swap(arr, start, j);
        return j;
    }
    
    private void swap(Entry[] arr, int i, int j) {
        Entry e = arr[i];
        arr[i] = arr[j];
        arr[j] = e;
    }
}

// O(n) Solution
class Solution {
    
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        List<Integer>[] freq = new List[nums.length + 1];
        for (int n : map.keySet()) {
            int times = map.get(n);
            if (freq[times] == null) {
                freq[times] = new ArrayList<>();
            }
            freq[times].add(n);
        }
        
        List<Integer> result = new ArrayList<>();
        int count = k;
        for (int i = nums.length; i >= 0 && count > 0; --i) {
            if (freq[i] != null) {
                result.addAll(freq[i]);
                count -= freq[i].size();
            }
        }
        return result;
    }
}
