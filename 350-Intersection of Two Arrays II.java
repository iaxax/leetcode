public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map1 = new HashMap<>();
        int n1 = nums1.length;
        for (int i = 0; i < n1; ++i) {
            map1.put(nums1[i], map1.getOrDefault(nums1[i], 0) + 1);
        }
        
        Map<Integer, Integer> map2 = new HashMap<>();
        int n2 = nums2.length;
        for (int i = 0; i < n2; ++i) {
            map2.put(nums2[i], map2.getOrDefault(nums2[i], 0) + 1);
        }
        
        List<Integer> l = new LinkedList<>();
        for (Integer num : map1.keySet()) {
            if (map2.containsKey(num)) {
                int gap = Math.min(map2.get(num), map1.get(num));
                for (int i = 0; i < gap; ++i) l.add(num);
            }
        }
        
        int size = l.size();
        int[] result = new int[size];
        int index = 0;
        for (Integer num : l) {
            result[index] = num;
            ++index;
        }
        return result;
    }
}
