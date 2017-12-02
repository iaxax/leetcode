public class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int current = n;
        while (current != 1) {
            if (set.contains(current)) {
                return false;
            }
            set.add(current);
            int sum = 0;
            while (current > 0) {
                sum += (current % 10) * (current % 10);
                current /= 10;
            }
            current = sum;
        }
        return true;
    }
}