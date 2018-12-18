class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        Map<String, List<Integer>> emailToNames = new HashMap<>();
        
        for (int i = 0; i < n; ++i) {
            List<String> account = accounts.get(i);
            String name = account.get(0);
            int m = account.size();
            for (int j = 1; j < m; ++j) {
                String email = account.get(j);
                List<Integer> indexes = emailToNames.getOrDefault(email, new ArrayList<>());
                indexes.add(i);
                emailToNames.put(email, indexes);
            }
        }
        
        int[] users = init(n);
        for (List<Integer> indexes : emailToNames.values()) {
            int m = indexes.size();
            for (int j = 1; j < m; ++j) {
                union(users, indexes.get(j), indexes.get(j - 1));
            }
        }

        Set<String>[] emails = new HashSet[n];
        for (int i = 0; i < n; ++i) {
            emails[i] = new HashSet<>();
        }
        for (int i = 0; i < n; ++i) {
            List<String> account = accounts.get(i);
            emails[find(users, i)].addAll(account.subList(1, account.size()));
        }

        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i < n; ++i) {
            if (!emails[i].isEmpty()) {
                List<String> list = new ArrayList<>(emails[i].size() + 1);
                List<String> elist = new ArrayList<>(emails[i]);
                Collections.sort(elist);
                
                list.add(accounts.get(i).get(0));
                list.addAll(elist);
                result.add(list);
            }
        }
        return result;
    }
    
    private int[] init(int n) {
        int[] ufs = new int[n];
        for (int i = 0; i < n; ++i) {
            ufs[i] = i;
        }
        return ufs;
    }
    
    private int find(int[] ufs, int i) {
        while (ufs[i] != i) {
            i = ufs[i];
        }
        return i;
    }
    
    private void union(int[] ufs, int i, int j) {
        int r1 = find(ufs, i), r2 = find(ufs, j);
        ufs[r1] = r2;
    }
}