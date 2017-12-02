public class Solution {
    public List<String> fizzBuzz(int n) {
        String[] strs = new String[n];
        for (int i = 2; i < n; i += 3) {
            strs[i] = "Fizz";
        }
        for (int i = 4; i < n; i += 5) {
            strs[i] = strs[i] == null ? "Buzz" : "FizzBuzz";
        }
        List<String> result = new LinkedList<>();
        for (int i = 0; i < n; ++i) {
            result.add(strs[i] == null ? String.valueOf(i + 1) : strs[i]);
        }
        return result;
    }
}
