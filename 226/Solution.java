import javax.swing.tree.TreeNode;

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
    public TreeNode invertTree(TreeNode root) {
        return mirror(root);
    }

    private static TreeNode mirror(TreeNode t1) {
        if(t1 == null) {
            return null;
        }

        TreeNode t2 = new TreeNode(t1.val);
        t2.left = mirror(t1.right);
        t2.right = mirror(t1.left);
        return t2;
    }
}