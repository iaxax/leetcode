// O(n^2) Solution
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n1 = list1.length, n2 = list2.length;
        int[] index = new int[n1];
        int min = n1 + n2, count = 1;
        for (int i = 0; i < n1; ++i) {
            int j = 0;
            while (j < n2 && !list1[i].equals(list2[j])) ++j;
            if (j < n2) {
                index[i] = i + j;
                if (index[i] < min) {
                    min = index[i]; count = 1;
                }
                else if (index[i] == min) ++count;
            }
        }
        String[] result = new String[count];
        for (int i = 0, j = 0; i < count; ++i, ++j) {
            while (j < n1 && index[j] != min) ++j;
            result[i] = list1[j];
        }
        return result;
    }
}

// O(n) Solution
class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int n1 = list1.length, n2 = list2.length;
        int min = n1 + n2;
        
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n2; ++i) {
            map.put(list2[i], i);
        }
        
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n1; ++i) {
            int sum = i + map.getOrDefault(list1[i], Integer.MAX_VALUE - i);
            if (sum < min) {
                result.clear();
                result.add(list1[i]);
                min = sum;
            }
            else if (sum == min) result.add(list1[i]);
        }

        return result.toArray(new String[result.size()]);
    }
}
