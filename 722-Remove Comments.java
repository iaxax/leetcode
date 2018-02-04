class Solution {
    public List<String> removeComments(String[] source) {
        List<String> result = new ArrayList<>(source.length);
        int i = 0, j = 0, lines = source.length;
        boolean inBlock = false;
        StringBuilder builder = new StringBuilder();
        
        while (i < lines) {
            char[] line = source[i].toCharArray();
            int len = line.length;
            
            if (inBlock) {
                while (j < len && line[j] != '*') ++j;
                while (j + 1 < len && line[j + 1] == '*') ++j;
                if (j >= len - 1) {
                    ++i; j = 0;
                } else {
                    if (line[j + 1] == '/') inBlock = false;
                    j += 2;
                }
            } else if (j < len) {
                while (j < len && line[j] != '/') {
                    builder.append(line[j++]);
                }
                
                if (j >= len - 1 || line[j + 1] == '/') {
                    if (j == len - 1) builder.append('/');
                    if (builder.length() != 0) result.add(builder.toString());
                    builder = new StringBuilder();
                    j = 0; ++i;
                } else if (line[j + 1] == '*') {
                    inBlock = true;
                    j += 2;
                } else {
                    builder.append('/');
                    j += 1;
                }
            } else {
                if (builder.length() != 0) result.add(builder.toString());
                builder = new StringBuilder();
                ++i; j = 0;
            }
        }
        
        return result;
    }
}
