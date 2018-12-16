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
    public boolean isCompleteTree(TreeNode root) {
        int level = height(root);
        boolean last = false;
        if(level < 2) {
            return true;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int l = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            l ++;
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if(l + 1 < level) {
                    if(node.left == null || node.right == null) {
                        return false;
                    } 
                }
                    
                if(node.left != null) {
                    if(last == true) {
                        return false;
                    }
                    queue.offer(node.left);
                }

                if(node.right != null) {
                      if(last == true) {
                        return false;
                    }
                    queue.offer(node.right);
                }
                
                if(l + 1 == level) {
                    if(node.left == null && node.right != null) {
                        return false;
                    }
                    
                    if(node.left == null || node.right == null) {
                        last = true;
                    }
                }
            }
        }
        
        return true;
    }
    
    private int height(TreeNode root) {
        if(root == null) {
            return 0;
        }
        
        return 1 + Math.max(height(root.left), height(root.right));
    }
}