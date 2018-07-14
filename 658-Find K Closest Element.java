class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int m = Math.abs(a - x), n = Math.abs(b - x);
            return m == n ? b - a : n - m;
        });
        for (int n : arr) {
            pq.offer(n);
            if (pq.size() > k) pq.poll();
        }
        
        List<Integer> result = new ArrayList<>(pq);
        Collections.sort(result);
        return result;
    }
}

class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = 0; i < k; ++i) {
            result.addLast(arr[i]);
        }
        
        int start = 0;
        while (start + k < arr.length) {
            if (Math.abs(arr[start] - x) <= Math.abs(arr[start + k] - x) && arr[start] != arr[start + k]) break;
            result.removeFirst();
            result.addLast(arr[start + k]);
            ++start;
        }
        
        return result;
    }
}
