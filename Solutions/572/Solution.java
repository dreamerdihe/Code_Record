// vanila version
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {        
        
        return s!= null && (isSame(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t));
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        
        if(s == null || t == null) {
            return false;
        }
        
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}

//depth checking version
class Solution {
    private List<TreeNode> nodes = new ArrayList<>();
    
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        
        if(s == null || t == null) {
            return false;
        }
        getDepth(s, getDepth(t, -2));
        
        for(TreeNode node : nodes) {
            if(node.val == t.val && isSame(node, t)) {
                return true;
            }
        }
        
        return false;
    }
    
    private int getDepth(TreeNode node, int d) {
        if(node == null) {
            return 0;
        }
        
        int depth = Math.max(getDepth(node.left, d), getDepth(node.right, d)) + 1;
        
        if(depth == d) {
            nodes.add(node);
        }
        
        return depth;
    }
    
    private boolean isSame(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }
        
        if(s == null || t == null) {
            return false;
        }
        
        return s.val == t.val && isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}