public class Solution {
    
    public List<String> readBinaryWatch(int num) {
        List<LinkedList<Integer>> selection = new LinkedList<>();
        combination(selection, new LinkedList<>(), num, 0);
        List<String> result = new LinkedList<>();
        for (LinkedList<Integer> list : selection) {
            String s = convert(list);
            if (s != null) result.add(s);
        }
        return result;
    }
    
    private void combination(List<LinkedList<Integer>> result, List<Integer> select, int remain, int start) {
        if (remain == 0) {
            LinkedList<Integer> temp = new LinkedList<>();
            temp.addAll(select);
            result.add(temp);
            return;
        }
        
        if (start < 10) {
            select.add(start);
            combination(result, select, remain - 1, start + 1);
            select.remove(select.size() - 1);
            combination(result, select, remain, start + 1);
        }
    }
    
    private String convert(List<Integer> list) {
        int hour = 0, minute = 0;
        for (Integer i : list) {
            if (i < 4) {
                hour += 1 << i;
            }
            else {
                minute += 1 << (i - 4);
            }
        }
        
        if (hour < 12 && minute < 60) {
            StringBuilder sb = new StringBuilder();
            sb.append(String.valueOf(hour)).append(":");
            if (minute < 10) sb.append("0");
            sb.append(String.valueOf(minute));
            return sb.toString();
        }
        return null;
    }
}
