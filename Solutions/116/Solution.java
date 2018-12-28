/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if(root == null) {
            return;
        }
        
        root.next = null;
        
        connect(root.left);
        connect(root.right);
        
        TreeLinkNode left = root.left;
        TreeLinkNode right = root.right;
        while(left!= null && right != null) {
            left.next = right;
            left = left.right;
            right = right.left;
        }
    }
}