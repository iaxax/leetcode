// heap sort O(nlogn)
public class Solution {
    
    public int findKthLargest(int[] nums, int k) {
        int[] heap = Arrays.copyOf(nums, nums.length);
        ajust(heap);
        popK(heap, k - 1);
        return heap[0];
    }
    
    private void ajust(int[] heap) {
        int n = heap.length;
        if (n <= 1) return;
        for (int i = (n - 2) / 2; i >= 0; --i) {
            shiftDown(heap, i, n);
        }
    }
    
    private void popK(int[] heap, int k) {
        int n = heap.length;
        for (int i = 0; i < k; ++i) {
            heap[0] = heap[--n];
            shiftDown(heap, 0, n);
        }
    }
    
    private void shiftDown(int[] heap, int start, int size) {
        int parent = start;
        int child = parent * 2 + 1;
        int temp = heap[parent];
        while (child < size) {
            if (child + 1 < size && heap[child] < heap[child + 1])
                ++child;
            if (temp < heap[child]) {
                heap[parent] = heap[child];
                parent = child;
                child = child * 2 + 1;
            }
            else {
                break;
            }
        }
        heap[parent] = temp;
    }
    
}

// selection algorithm
public class Solution {
    public int findKthLargest(int[] nums, int k) {
        int index = nums.length - k;
        int start = 0, end = nums.length - 1;
        while (start < end) {
            int i = partition(nums, start, end);
            if (i < index) {
                start = i + 1;
            }
            else if (i > index) {
                end = i - 1;
            }
            else {
                break;
            }
        }
        return nums[index];
    }
    
    private int partition(int[] nums, int start, int end) {
        int i = start, j = end + 1;
        while (true) {
            while (i < end && nums[++i] < nums[start]);
            while (j > start && nums[--j] > nums[start]);
            if (i >= j) break;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
        int temp = nums[start];
        nums[start] = nums[j];
        nums[j] = temp;
        return j;
    }
}

