class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return null;
        }
        
        if(key == root.val) {
            if(root.right == null) {
                return root.left;
            }
            
            if(root.left == null) {
                return root.right;
            }
            
            TreeNode replace = largerMin(root.right);
            replace.right = deleteNode(root.right, replace.val);
            replace.left = root.left;
            return replace;
            
        } else if(key < root.val) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }
        
        return root;
    }
    
    private TreeNode largerMin(TreeNode root) {
        while(root.left != null) {
            root = root.left;
        }
        
        return root;
    }
}