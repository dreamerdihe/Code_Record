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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            int size = queue.size();
            int count = 0;
            for(int i = 0; i < size; i++) {
                TreeNode now = queue.poll();
                count ++;
                if(count == size) {
                    result.add(now.val);
                }
                
                if(now.left != null) {
                    queue.offer(now.left);
                }
                
                if(now.right != null) {
                    queue.offer(now.right);
                }
            }

        }
        
        return result;
    }
}








