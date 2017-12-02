class Solution {
public:
    int compareVersion(string version1, string version2) {
        int size1 = version1.size(), size2 = version2.size();
        int i = 0, j = 0;
        while (i < size1 || j < size2) {
            int num1 = 0;
            while (i < size1 && version1[i] != '.') {
                num1 = num1 * 10 + (version1[i++] - '0');
            }
            
            int num2 = 0;
            while (j < size2 && version2[j] != '.') {
                num2 = num2 * 10 + (version2[j++] - '0');
            }
            
            if (num1 < num2) {
                return -1;
            }
            else if (num1 > num2) {
                return 1;
            }
            
            ++i; ++j;
        }
        
        return 0;
    }
};