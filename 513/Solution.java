// bfs
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
    public int findBottomLeftValue(TreeNode root) {
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode left = root;
        while(!queue.isEmpty()) {
            int size = queue.size();
            
            for(int i = 0; i < size; i ++) {
                TreeNode node = queue.poll();
                if(i == 0) {
                    left = node;
                }
                
                if(node.left != null) {
                    queue.offer(node.left);
                }
                
                if(node.right != null) {
                    queue.offer(node.right);
                }
            } 
        }
        
        return left.val;
    }
}
// dfs
class Solution {
    private int left;
    private int leftLevel = Integer.MIN_VALUE;
    
    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);    
        return left;
    }
    
    private void dfs(TreeNode root, int level) {
        if(root.left == null && root.right == null) {
            if(level > leftLevel) {
                leftLevel = level;
                left = root.val;
            }
            return;
        }
        
        if(root.left != null) {
            dfs(root.left, level + 1);    
        }
        
        if(root.right != null) {
            dfs(root.right, level + 1);
        }
        
        return;
    }
}