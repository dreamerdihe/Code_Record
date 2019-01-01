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
    public String tree2str(TreeNode t) {
        StringBuilder result = new StringBuilder();
        dfs(t, result);
        return result.toString();
    }
    
    private void dfs(TreeNode root, StringBuilder result) {
        if(root == null) {
            return;
        }
        
        result.append(Integer.toString(root.val));
        if(root.left != null || root.left == null && root.right != null) {
            result.append("(");
            dfs(root.left, result);
            result.append(")");        
        }
        
        
        if(root.right != null) {
            result.append("(");
            dfs(root.right, result);
            result.append(")");    
        }
        
        return;
    }
}