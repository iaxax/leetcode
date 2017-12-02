public class Solution {
    private static int[] position = {
        2, 3, 3, 2, 1, 2, 2, 2, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 2, 1, 1, 3, 1, 3, 1, 3
    };
    
    public String[] findWords(String[] words) {
        List<String> list = new ArrayList<>();
        for (String str : words) {
            int i = 0, n = str.length();           
            String lstr = str.toLowerCase();
            boolean found = true;
            while (i < n) {
                int index1 = lstr.charAt(i) - 'a';
                if (i + 1 == n) {
                    if (!(index1 >= 0 && index1 < 26)) found = false;
                    break;
                }
                int index2 = lstr.charAt(i + 1) - 'a';
                if (!(index1 >= 0 && index1 < 26 && index2 >= 0 && index2 < 26)
			|| position[index1] != position[index2]) {
                    found = false; break;
                };
                ++i;
            }
            if (found) list.add(str);
        }
        
        int size = list.size();
        String[] result = new String[size];
        for (int i = 0; i < size; ++i) {
            result[i] = list.get(i);
        }
        return result;
    }
}
