// this solution will destroy origin input array, so it costs O(n) space
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            while (nums[nums[i] - 1] != nums[i]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < size; ++i) {
            if (nums[i] != i + 1) result.add(nums[i]);
        }
        return result;
    }
}

// a O(1) space solution
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int size = nums.length;
        List<Integer> result = new LinkedList<>();
        for (int i = 0; i < size; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(index + 1);
            } else {
                nums[index] = -nums[index];
            }
        }
        
        for (int i = 0; i < size; ++i) {
            if (nums[i] < 0) nums[i] = -nums[i];
        }
        return result;
    }
}
