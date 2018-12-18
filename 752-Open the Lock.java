class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deads = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        if (!deads.contains("0000")) {
            q.offer("0000");
            visited.add("0000");
        }
        
        int level = 0;
        while (!q.isEmpty()) {
            int n = q.size();
            for (int i = 0; i < n; ++i) {
                String str = q.poll();
                if (str.equals(target)) return level;
                for (int j = 0; j < 4; ++j) {
                    char c = str.charAt(j);
                    String s1 = str.substring(0, j)
                        + (c == '0' ? '9' : (char)(c - 1))
                        + str.substring(j + 1);
                    String s2 = str.substring(0, j)
                        + (c == '9' ? '0' : (char)(c + 1))
                        + str.substring(j + 1);
                    if (!visited.contains(s1) && !deads.contains(s1)) {
                        q.offer(s1);
                        visited.add(s1);
                    }
                    if (!visited.contains(s2) && !deads.contains(s2)) {
                        q.offer(s2);
                        visited.add(s2);
                    }
                }
            }
            level += 1;
        }
        return -1;
    }
}

class Solution {
    public int openLock(String[] deadends, String target) {
        HashSet<String> deads = new HashSet<>(Arrays.asList(deadends));
        HashSet<String> begin = new HashSet<>();
        HashSet<String> end = new HashSet<>();
        if (!deads.contains("0000")) {
            begin.add("0000");
            end.add(target);
        }
        
        int level = 0;
        while (!begin.isEmpty() && !end.isEmpty()) {
            if (begin.size() > end.size()) {
                HashSet<String> temp = begin;
                begin = end;
                end = temp;
            }
            
            HashSet<String> temp = new HashSet<>();
            for (String str : begin) {
                if (end.contains(str)) return level;
                if (deads.contains(str)) continue;
                
                for (int j = 0; j < 4; ++j) {
                    char c = str.charAt(j);
                    String s1 = str.substring(0, j)
                        + (c == '0' ? '9' : (char)(c - 1))
                        + str.substring(j + 1);
                    String s2 = str.substring(0, j)
                        + (c == '9' ? '0' : (char)(c + 1))
                        + str.substring(j + 1);
                    if (!deads.contains(s1)) {
                        temp.add(s1);
                    }
                    if (!deads.contains(s2)) {
                        temp.add(s2);
                    }
                }
            }
            
            level += 1;
            begin = temp;
        }
        return -1;
    }
}