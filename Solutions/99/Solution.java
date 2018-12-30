class Solution {
    private List<TreeNode> mis = new ArrayList<>();
    private TreeNode prev = null;
    
    public void recoverTree(TreeNode root) {
        dfs(root);
        int temp = mis.get(0).val;
        mis.get(0).val = mis.get(mis.size() - 1).val;
        mis.get(mis.size() - 1).val = temp;
        return;
    }
    
    private void dfs(TreeNode root) {
        if(root == null) {
            return;
        }
        
        dfs(root.left);
        if(prev != null && prev.val > root.val) {
                mis.add(prev);
                mis.add(root);
        }
            
        prev = root;
        dfs(root.right);
        
        return;
    }
}