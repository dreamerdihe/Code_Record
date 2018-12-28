/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//traverse
class Solution {
    public int maxDepth(TreeNode root) {
        int depthMax = helper(root);
        return depthMax;
    }
    
    private int helper(TreeNode root){
        int depth = 0;
        
        if(root == null){
            return depth;
        }
        
        depth = Math.max(helper(root.left), helper(root.right)) + 1;
        return depth;
    }
}