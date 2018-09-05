class Solution {
    public int findShortestSubArray(int[] nums) {
        Item[] count = new Item[50000];
        int degree = 0, length = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int num = nums[i];
            if (count[num] == null) {
                count[num] = new Item(i, i, 0);
            }
            
            Item item = count[num];
            item.count += 1;
            item.end = i;
            
            if (item.count > degree) {
                degree = item.count;
                length = item.end - item.start + 1;
            } else if (item.count == degree && (item.end - item.start + 1) < length) {
                length = item.end - item.start + 1;
            }
        }
        return length;
    }
    
    private static class Item {
        int start, end, count;
        Item(int s, int e, int c) {
            start = s; end = e; count = c;
        }
    }
}