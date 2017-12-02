// O(n^2) Solution
class Solution {
    
    private static class Pair implements Comparable<Pair> {
        int a, b;
        Pair(int x, int y) { a = x; b = y; }
        public int compareTo(Pair p) { return a + b - (p.a + p.b); }
    }
    
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        List<Pair> all = new ArrayList<>(n1 * n2);
        for (int i = 0; i < n1; ++i) {
            for (int j = 0; j < n2; ++j) {
                all.add(new Pair(nums1[i], nums2[j]));
            }
        }
        Collections.sort(all);
        
        List<int[]> result = new ArrayList<>(k);
        int count = k > (n1 * n2) ? n1 * n2 : k;
        for (int i = 0; i < count; ++i) {
            Pair p = all.get(i);
            int[] arr = {p.a, p.b};
            result.add(arr);
        }
        return result;
    }
}

// O(nlogn) Solution
class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n1 = nums1.length, n2 = nums2.length;
        if (n1 == 0 || n2 == 0 || k == 0) {
            return new ArrayList<>();
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>(k, (a, b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < k && i < n1; ++i) {
            pq.offer(new int[] {nums1[i], nums2[0], 0});
        }
        
        List<int[]> result = new ArrayList<>(k);
        while (k-- > 0 && !pq.isEmpty()) {
            int[] p = pq.poll();
            result.add(new int[] {p[0], p[1]});
            if (p[2] == n2 - 1) continue;
            pq.offer(new int[] {p[0], nums2[p[2] + 1], p[2] + 1});
        }
        return result;
    }
}
