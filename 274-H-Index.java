// O(nlogn) Solution
class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int n = citations.length;
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (citations[mid] >= n - mid) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }
        return n - low;
    }
}

// O(n) Solution
class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n + 1];
        for (int num : citations) {
            count[num > n ? n : num] += 1;
        }
        
        int sum = 0;
        for (int i = n; i >= 0; --i) {
            sum += count[i];
            if (sum >= i) return i;
        }
        return 0;
    }
}
