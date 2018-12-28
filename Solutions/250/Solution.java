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
    public class Result {
        int count;
        int uniVal;
        
        Result(int x, int y) {
            count = x;
            uniVal = y;
        }
    }
    
    public int countUnivalSubtrees(TreeNode root) {
        Result result = helper(root);
        return result.count;
    }
    
    private Result helper(TreeNode root) {
        if(root == null) {
            return new Result(0, Integer.MIN_VALUE);
        }
        
        if(root.left == null && root.right == null) {
            return new Result(1, root.val);
        }
        
        Result left = helper(root.left);
        Result right = helper(root.right);
        
        if((root.val == left.uniVal || root.left == null) && (root.val == right.uniVal || root.right == null)) {
            return new Result(left.count + right.count + 1, root.val);
        }
        
        return new Result(left.count + right.count, Integer.MIN_VALUE);
    }
}









