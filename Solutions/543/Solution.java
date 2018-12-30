class Solution {
    private int result = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return result;
    }
    
    private int dfs(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        int left = dfs(root.left);
        int right = dfs(root.right);
        result = Math.max(result, left + right);
        
        
        return Math.max(left, right) + 1;
    }
}