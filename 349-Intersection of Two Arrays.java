public class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        int n1 = nums1.length;
        for (int i = 0; i < n1; ++i) {
            set1.add(nums1[i]);
        }
        
        Set<Integer> set2 = new HashSet<>();
        int n2 = nums2.length;
        for (int i = 0; i < n2; ++i) {
            if (set1.contains(nums2[i])) {
                set2.add(nums2[i]);
            }
        }
        
        int size = set2.size();
        int[] result = new int[size];
        int index = 0;
        for (int i : set2) {
            result[index] = i;
            ++index;
        }
        return result;
    }
}
