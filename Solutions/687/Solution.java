class Solution {
    private int result = 0;
    public int longestUnivaluePath(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(root.left == null || root.left.val != root.val) {
            left = 0;
        }
        
        if(root.right == null || root.right.val != root.val) {
            right = 0;
        }
        
        result = Math.max(result, left + right);
        
        return Math.max(left, right) + 1;
    }
}