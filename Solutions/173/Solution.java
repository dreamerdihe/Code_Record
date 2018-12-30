class BSTIterator {
    Stack<TreeNode> stack = new Stack<>();
    public BSTIterator(TreeNode root) {
        helper(root);
    }
    
    public int next() {
        TreeNode result = stack.pop();
        TreeNode right = result.right;
        helper(right);
        return result.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
    
    private void helper(TreeNode root) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
        
        return;
    }
}