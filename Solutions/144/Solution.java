import java.util.Stack;
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
    public List<Integer> preorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> preorder = new ArrayList<>();
        if(root == null) {
            return preorder;
        }

        stack.push(root);
        while(!stack.isEmpty()) {
            TreeNode now = stack.pop();
            preorder.add(now.val);
            
            if(now.right != null) {
                stack.push(now.right);
            }
            if(now.left != null) {
                stack.push(now.left);
            }
        }

        return preorder;
    }
}