class Solution {
    public int findMaximumXOR(int[] nums) {
        int size = nums.length;
        if (size <= 1) return 0;

        TrieNode head = buildTrie(nums);

        int maxXor = 0;
        for (int n : nums) {
            TrieNode current = head;
            int xor = 0;
            for (int j = 30; j >= 0; --j) {
                if ((n & mask[j]) == 0) {
                    if (current.next[1] != null) {
                        xor += mask[j];
                        current = current.next[1];
                    } else {
                        current = current.next[0];
                    }
                } else {
                    if (current.next[0] != null) {
                        xor += mask[j];
                        current = current.next[0];
                    } else {
                        current = current.next[1];
                    }
                }
            }
            maxXor = Math.max(maxXor, xor);
        }

        return maxXor;
    }

    private TrieNode buildTrie(int[] nums) {
        TrieNode head = new TrieNode();
        for (int n : nums) {
            TrieNode current = head;
            for (int i = 30; i >= 0; --i) {
                if ((n & mask[i]) == 0) {
                    if (current.next[0] == null)
                        current.next[0] = new TrieNode();
                    current = current.next[0];
                } else {
                    if (current.next[1] == null)
                        current.next[1] = new TrieNode();
                    current = current.next[1];
                }
            }
        }
        return head;
    }

    private class TrieNode {
        TrieNode[] next = new TrieNode[2];
    }

    private static int[] mask = new int[32];

    static {
        for (int i = 0; i < 32; ++i) {
            mask[i] = 1 << i;
        }
    }

}

// faster solution
class Solution {
    public int findMaximumXOR(int[] nums) {
        int mask = 0, maxXor = 0;
        for (int i = 30; i >= 0; --i) {
            mask = mask | (1 << i);
            HashSet<Integer> set = new HashSet<>();
            for (int n : nums) set.add(n & mask);

            int temp = maxXor | (1 << i);
            for (int prefix : set) {
                if (set.contains(temp ^ prefix)) {
                    maxXor = temp;
                    break;
                }
            }
        }
        return maxXor;
    }
}
