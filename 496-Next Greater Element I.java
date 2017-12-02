public class Solution {
    public int[] nextGreaterElement(int[] findNums, int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();
        for (int num : nums) {
            while (!stack.isEmpty() && stack.peek() < num) {
                map.put(stack.pop(), num);
            }
            stack.push(num);
        }
        
        int n = findNums.length;
        int[] result = new int[n];
        for (int i = 0; i < n; ++i) {
            result[i] = map.getOrDefault(findNums[i], -1);
        }
        return result;
    }
}
