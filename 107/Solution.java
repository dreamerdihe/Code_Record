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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Stack<List<Integer>> stack = new Stack<>();
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                level.add(now.val);
                
                if(now.left != null) {
                    queue.offer(now.left);
                }
                
                if(now.right != null) {
                    queue.offer(now.right);
                }
            }
            
            stack.push(level);
        }
        
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }
        
        return result;
    }
}









