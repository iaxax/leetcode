class Solution {
    public int findLUSlength(String[] strs) {
        if (strs.length == 0) return 0;
        Arrays.sort(strs, (a, b) -> a.length() == b.length() ? a.compareTo(b) : b.length() - a.length());

        int size = strs.length;
        List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; ++i) {
            int start = i;
            while (i + 1 < size && strs[i].equals(strs[i + 1])) {
                i = i + 1;
            }
            if (i == start) {
                if (!subsequence(list, strs[start])) return strs[start].length();
            } else {
                list.add(strs[start]);
            }
        }
        return -1;
    }
    
    private boolean subsequence(List<String> list, String str) {
        for (String s : list) {
            if (subsequence(str, s)) return true;
        }
        return false;
    }
    
    private boolean subsequence(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = 0, j = 0;
        while (i < len1) {
            char c = s1.charAt(i++);
            while (j < len2 && s2.charAt(j) != c) ++j;
            if (j == len2) return false;
            ++j;
        }
        return true;
    }
}

class Solution {
    
    public int findLUSlength(String[] strs) {
        HashMap<String, Integer> count = new HashMap<>();
        for (String s : strs) {
            count.put(s, count.getOrDefault(s, 0) + 1);
        }
        
        List<Map.Entry<String, Integer>> list = new ArrayList<>(count.size());
        for (Map.Entry<String, Integer> entry : count.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, (a, b) -> b.getKey().length() - a.getKey().length());

        int size = list.size();
        for (int i = 0; i < size; ++i) {
            Map.Entry<String, Integer> entry = list.get(i);
            if (entry.getValue() == 1) {
                int j = 0;
                for (; j < i; ++j) {
                    if (subsequence(entry.getKey(), list.get(j).getKey())) break;
                }
                if (j == i) return entry.getKey().length();
            }
        }
        return -1;
    }
    
    private boolean subsequence(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int i = 0, j = 0;
        while (i < len1 && j < len2) {
            if (s1.charAt(i) == s2.charAt(j)) ++i;
            ++j;
        }
        return i == len1;
    }
}
