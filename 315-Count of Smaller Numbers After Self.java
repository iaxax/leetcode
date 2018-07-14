class Solution {
    private int[] bit;
    
    public List<Integer> countSmaller(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int n : nums) {
            min = Math.min(min, n);
            max = Math.max(max, n);
        }
        bit = new int[max - min + 2];
        
        LinkedList<Integer> result = new LinkedList<>();
        for (int i = nums.length - 1; i >= 0; --i) {
            result.addFirst(sum(nums[i] - min));
            add(nums[i] - min + 1);
        }
        return result;
    }
    
    private int lowbit(int i) {
        return i & -i;
    }
    
    private void add(int i) {
        for (int j = i; j < bit.length; j += lowbit(j)) {
            ++bit[j];
        }
    }
    
    private int sum(int i) {
        int s = 0;
        for (int j = i; j >= 1; j -= lowbit(j)) {
            s += bit[j];
        }
        return s;
    }
}