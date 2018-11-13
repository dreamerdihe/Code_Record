/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        return mirror(root, root);
    }
    
    private static boolean mirror(TreeNode t1,  TreeNode t2) {
        if(t1 == null && t2 == null) {
            return true;
        }
        
        if(t1 == null || t2 == null) {
            return false;
        }
        
        if(t1.val == t2.val && mirror(t1.left, t2.right) && mirror(t1.right, t2.left)) {
            return true;
        }
        
        return false;
    }
}