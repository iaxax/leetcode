class NumArray {
    
    private static class TreeNode {
        int start, end, sum;
        TreeNode left, right;
        TreeNode(int s, int e) {
            start = s; end = e; sum = 0;
        }
    }
    
    private TreeNode root;

    public NumArray(int[] nums) {
        root = build(nums, 0, nums.length - 1);
    }
    
    private TreeNode build(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        
        TreeNode root = new TreeNode(start, end);
        if (start == end) {
            root.sum = nums[start];
        }
        else {
            int mid = (start + end) >> 1;
            root.left = build(nums, start, mid);
            root.right = build(nums, mid + 1, end);
            root.sum = root.left.sum + root.right.sum;
        }
        return root;
    }
    
    public void update(int i, int val) {
        update(root, i, val);
    }
    
    private void update(TreeNode n, int i, int val) {
        if (n.start == n.end) {
            n.sum = val;
        }
        else {
            int mid = (n.start + n.end) >> 1;
            if (i <= mid) {
                update(n.left, i, val);
            }
            else {
                update(n.right, i, val);
            }
            n.sum = n.left.sum + n.right.sum;
        }
    }
    
    public int sumRange(int i, int j) {
        return sumRange(root, i, j);
    }
    
    private int sumRange(TreeNode n, int i, int j) {
        if (n.start == i && n.end == j) {
            return n.sum;
        }
        else {
            int mid = (n.start + n.end) >> 1;
            if (i > mid) {
                return sumRange(n.right, i, j);
            }
            else if (j <= mid) {
                return sumRange(n.left, i, j);
            }
            else {
                return sumRange(n.left, i, mid) + sumRange(n.right, mid + 1, j);
            }
        }
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
