// O(kn^2) Solution
class Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int n1 = words[i].length();
                int n2 = words[j].length();
                if (n1 * n2 > max) {
                    boolean[] set = new boolean[26];
                    for (char c : words[i].toCharArray()) {
                        set[c - 'a'] = true;
                    }
                    boolean distinct = true;
                    for (char c : words[j].toCharArray()) {
                        if (set[c - 'a']) {
                            distinct = false;
                            break;
                        }
                    }
                    if (distinct) {
                        max = n1 * n2;
                    }
                }
            }
        }
        
        return max;
    }
}

// O(n^2) Solutionclass Solution {
    public int maxProduct(String[] words) {
        int n = words.length;
        int[] bitmap = new int[n];
        for (int i = 0; i < n; ++i) {
            for (char c : words[i].toCharArray()) {
                bitmap[i] |= 1 << (c - 'a');
            }
        }
        
        int max = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j < n; ++j) {
                if ((bitmap[i] & bitmap[j]) == 0 && words[i].length() * words[j].length() > max) {
                    max = words[i].length() * words[j].length();
                }
            }
        }
        return max;
    }
}
