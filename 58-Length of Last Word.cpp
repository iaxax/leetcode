class Solution {
public:
    int lengthOfLastWord(string s) {
        int len = s.size(), result = 0;
        
        for (int i = 0; i < len; ++i) {
            while (i < len && s[i] == ' ') {
                ++i;
            }
            
            int l = 0;
            while (i < len && s[i] != ' ') {
                ++l; ++i;
            }
            
            result = l > 0 ? l : result;
        }
        return result;
    }
};