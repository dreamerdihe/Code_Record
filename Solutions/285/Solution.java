// recursion version
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) {
            return null;
        }
        
        if(p.val >= root.val) {
            return inorderSuccessor(root.right, p);
        } else {
            TreeNode res = inorderSuccessor(root.left, p);
            return res == null ? root : res;
        }
    }
}

class Solution {
    private int flag = -1;
    private TreeNode result = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(p == null) {
            return result;
        }
        
        dfs(root, p);
        return result;
    }
    
    private void dfs(TreeNode root, TreeNode p) {
        if(flag == 1) {
            return;
        }
        
        if(root == null) {
            return;
        }

        
        dfs(root.left, p);
        if(flag == 0) {
            result = root;
            flag = 1;
            return;
        }
        
        if(root.val == p.val) {
            flag = 0;
        }
        
        dfs(root.right, p);
        
        return;
    }
}