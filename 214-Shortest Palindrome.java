// inefficient solution O(n^2)
public class Solution {
    public String shortestPalindrome(String s) {
        String newStr = preprocess(s);
        int length = newStr.length();
        int longest = 0;
        for (int i = 0; i <= length / 2; ++i) {
            int left = i, right = i;
            int len = 0;
            while (left >= 0 && right < length && newStr.charAt(left) == newStr.charAt(right)) {
                len += 1;
                left -= 1;
                right += 1;
            }
            if (left == -1) {
                longest = Math.max(longest, right - i - 1);
            }
        }
        
        String prefix = s.substring(longest);
        return new StringBuilder(prefix).reverse().append(s).toString();
    }
    
    private String preprocess(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            sb.append("#").append(s.charAt(i));
        }
        return sb.append("#").toString();
    }
}

// slightly efficient solution O(n^2)
public class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        int i = 0;
        for (int j = n - 1; j >= 0; --j) {
            if (s.charAt(i) == s.charAt(j))
                ++i;
        }
        if (i == n)
            return s;
        String remain = s.substring(i);
        return new StringBuilder(remain).reverse()
		.append(shortestPalindrome(s.substring(0, i)))
		.append(remain).toString();
    }
}

// efficient solution O(n)
public class Solution {
    public String shortestPalindrome(String s) {
        String reverse = new StringBuilder(s).reverse().toString();
        String newStr = s + "#" + reverse;
        int newLen = newStr.length();
        int[] f = new int[newLen];
        f[0] = 0;
        for (int i = 1; i < newLen; ++i) {
            int t = f[i - 1];
            while (t > 0 && newStr.charAt(i) != newStr.charAt(t)) {
                t = f[t - 1];
            }
            if (newStr.charAt(i) == newStr.charAt(t)) {
                ++t;
            }
            f[i] = t;
        }
        return reverse.substring(0, s.length() - f[newLen - 1]) + s;
    }
}

