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
        
        while(root != null) {
            TreeLinkNode temp = new TreeLinkNode(0);
            TreeLinkNode now = temp;
            
            while(root != null) {
                if(root.left != null) {
                    now.next = root.left;
                    now = now.next;
                }
                
                if(root.right != null) {
                    now.next = root.right;
                    now = now.next;
                }
                
                root = root.next;
            }
            
            root = temp.next;      
        }
        return;
    }
}