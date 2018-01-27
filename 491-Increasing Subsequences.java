class Solution {
    public List<List<Integer>> findSubsequences(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findSubsequences(result, new ArrayList<>(), nums, 0);
        return result;
    }
    
    private void findSubsequences(List<List<Integer>> result, List<Integer> sequence, int[] nums, int start) {
        if (start == nums.length) {
            if (sequence.size() > 1) {
                List<Integer> list = new ArrayList<>(sequence);
                result.add(list);
            }
            return;
        }
        
        if (sequence.size() == 0 || sequence.get(sequence.size() - 1) <= nums[start]) {
            sequence.add(nums[start]);
            findSubsequences(result, sequence, nums, start + 1);
            sequence.remove(sequence.size() - 1);
        }
        
        if (sequence.size() == 0 || sequence.get(sequence.size() - 1) != nums[start]) 
            findSubsequences(result, sequence, nums, start + 1);
    }
}
