public class Solution {
    public String largestNumber(int[] nums) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int num : nums) {
            list.add(num);
        }
        
        Collections.sort(list, (Integer a, Integer b) -> {
            String str1 = String.valueOf(a) + String.valueOf(b);
            String str2 = String.valueOf(b) + String.valueOf(a);
            return -str1.compareTo(str2);
        });
        
        StringBuilder sb = new StringBuilder();
        for (Integer num : list) {
            sb.append(String.valueOf(num));
        }
        
        return sb.charAt(0) == '0' ? "0" : sb.toString();
    }
    
    private int getLen(int num) {
        if (num == 0) {
            return 1;
        }
        
        int len = 0;
        while (num > 0) {
            num /= 10;
            len += 1;
        }
        return len;
    }
}