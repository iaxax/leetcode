class Solution {
public:
    void reverseWords(string &s) {
        istringstream iss(s);
        string str, reverse;
        while (iss >> str) {
            reverse = str + " " + reverse;
        }
        s = reverse.substr(0, reverse.size() - 1);
    }
};

// in-place solution
class Solution {
public:
    void reverseWords(string &s) {
        reverse(s.begin(), s.end());
        int index = 0;
        for (int i = 0; i < s.size(); ++i) {
            if (s[i] != ' ') {
                if (index != 0) {
                    s[index++] = ' ';
                }
                
                int j = i;
                while (j < s.size() && s[j] != ' ') {
                    s[index++] = s[j++];
                }
                reverse(s.begin() + index - (j - i), s.begin() + index);
                i = j;
            }
        }
        s.erase(s.begin() + index, s.end());
    }
};