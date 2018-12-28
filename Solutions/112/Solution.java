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
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root == null) {
            return false;
        }
        
        return dfs(root, sum);
    }
    
    private static boolean dfs(TreeNode root, int sumRes) {
        if(root.left == null && root.right == null){
            sumRes -= root.val;
            if(sumRes == 0) {
                return true;
            }
            
            return false;
        }
        
        if(root.left == null && root.right != null) {
            return dfs(root.right, sumRes - root.val);
        }
        
        if(root.right == null && root.left != null) {
            return dfs(root.left, sumRes - root.val);
        }
        
        return dfs(root.left, sumRes - root.val) || dfs(root.right, sumRes - root.val);
    }
}