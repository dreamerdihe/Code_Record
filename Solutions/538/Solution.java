class Solution {
    private int prev = 0;
    public TreeNode convertBST(TreeNode root) {
        dfs(root);
        return root;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        
        dfs(root.right);
        root.val += prev;
        prev = root.val;
        dfs(root.left);
    }
}