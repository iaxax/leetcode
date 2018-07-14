// brute-force + simple prune
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        HashSet<String> result = new HashSet<>();
        int[] maxLen = {0};
        int diff = 0;
        s = trim(s);
        for (char c : s.toCharArray()) {
            if (c == '(') {
                diff += 1;
            } else if (c == ')') {
                diff -= 1;
            }
        }
        remove(result, s, maxLen, diff);
        
        List<String> list = new ArrayList<>();
        for (String str : result) {
            if (str.length() == maxLen[0]) {
                list.add(str);
            }
        }
        return list;
    }
    
    private String trim(String s) {
        StringBuilder pre = new StringBuilder(s.length());
        int i = 0, l = s.length();
        while (i < l && s.charAt(i) != '(') {
            if (s.charAt(i) != ')') {
                pre.append(s.charAt(i));
            }
            ++i;
        }
        
        String post = "";
        int j = l - 1;
        while (j >= i && s.charAt(j) != ')') {
            if (s.charAt(j) != '(') {
                post = s.charAt(j) + post;
            }
            --j;
        }
        
        return pre + s.substring(i, j + 1) + post;
    }
    
    private void remove(HashSet<String> result, String s, int[] maxLen, int diff) {
        if (s.length() < maxLen[0]) {
            return;
        }
        
        if (diff == 0 && valid(s)) {
            result.add(s);
            maxLen[0] = s.length();
        } else {
            int length = s.length();
            for (int i = 0; i < length; ++i) {
                char c = s.charAt(i);
                if (diff < 0 && c == ')') {
                    remove(result, s.substring(0, i) + s.substring(i + 1), maxLen, diff + 1);
                } else if (diff > 0 && c == '(') {
                    remove(result, s.substring(0, i) + s.substring(i + 1), maxLen, diff - 1);
                } else if (diff == 0) {
                    remove(result, s.substring(0, i) + s.substring(i + 1), maxLen, 0);
                }
                while (i + 1 < length && s.charAt(i + 1) == c) ++i;
            }
        }
    }
    
    private boolean valid(String s) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) return false;
                stack.pop();
            }
        }
        return stack.isEmpty();
    }
}

// faster solution
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>(s.length());
        int l = 0, r = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') ++l;
            else if (l == 0 && c == ')') ++r;
            else if (c == ')') --l;
        }
        dfs(result, s, 0, l, r);
        return result;
    }
    
    private void dfs(List<String> result, String s, int start, int l, int r) {
        if (l == 0 && r == 0) {
            if (isValid(s)) {
                result.add(s);
            }
            return;
        }
        
        for (int i = start; i < s.length(); ++i) {
            if (i != start && s.charAt(i) == s.charAt(i - 1)) continue;
            char c = s.charAt(i);
            if (c == '(' || c == ')') {
                String str = s.substring(0, i) + s.substring(i + 1);
                if (r > 0) {
                    if (c == ')') dfs(result, str, i, l, r - 1);
                } else if (l > 0) {
                    if (c == '(') dfs(result, str, i, l - 1, r);
                }
            }
        }
    }
    
    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') ++count;
            else if (c == ')') --count;
            if (count < 0) return false;
        }
        return true;
    }
}