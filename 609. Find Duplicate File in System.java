class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String p : paths) {
            String[] temp = p.split(" ");
            String dir = temp[0];
            for (int i = 1; i < temp.length; ++i) {
                int len = temp[i].length();
                StringBuilder name = new StringBuilder(len);
                int j = 0;
                while (j < len && temp[i].charAt(j) != '(') {
                    name.append(temp[i].charAt(j++));
                }
                
                StringBuilder content = new StringBuilder(len);
                ++j;
                while (j < len && temp[i].charAt(j) != ')') {
                    content.append(temp[i].charAt(j++));
                }
                
                String c = content.toString();
                List<String> list = map.get(c);
                if (list == null) {
                    List<String> l = new ArrayList<>();
                    l.add(dir + "/" + name.toString());
                    map.put(c, l);
                } else {
                    list.add(dir + "/" + name.toString());
                }
            }
        }
        
        List<List<String>> result = new ArrayList<>();
        for (List<String> list : map.values()) {
            if (list.size() > 1) result.add(list);
        }
        return result;
    }
}
