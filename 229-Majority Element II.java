class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if (nums.length == 0) return new ArrayList<>();
        
        int count1 = 0, count2 = 0, candidate1 = 0, candidate2 = 1;
        for (int num : nums) {
            if (num == candidate1) ++count1;
            else if (num == candidate2) ++count2;
            else if (count1 == 0) {count1 = 1; candidate1 = num;}
            else if (count2 == 0) {count2 = 1; candidate2 = num;}
            else {count1 -= 1; count2 -= 1;}
        }
        
        count1 = 0; count2 = 0;
        for (int num : nums) {
            if (num == candidate1) ++count1;
            if (num == candidate2) ++count2;
        }
        
        List<Integer> result = new ArrayList<>();
        if (count1 > nums.length / 3) result.add(candidate1);
        if (count2 > nums.length / 3) result.add(candidate2);
        return result;
    }
}
