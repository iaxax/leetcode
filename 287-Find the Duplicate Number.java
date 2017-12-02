class Solution {
    public int findDuplicate(int[] nums) {
        if (nums.length > 1) {
            int walker = nums[0], runner = nums[nums[0]];
            while (walker != runner) {
                walker = nums[walker];
                runner = nums[nums[runner]];
            }
            
            int head = 0;
            while (head != walker) {
                walker = nums[walker];
                head = nums[head];
            }
            
            return head;
        }
        
        return -1;
    }
}
