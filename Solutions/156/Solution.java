class Solution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
       return dfs(root, null);
    }
    
    private TreeNode dfs(TreeNode node, TreeNode prev) {
        if(node == null) {
            return prev;
        }
        
        TreeNode root = dfs(node.left, node);
        
        if(prev != null) {
            node.right = prev;
            node.left = prev.right;  
            prev.left = null;
            prev.right = null;
        }
        
        return root;
    }
}